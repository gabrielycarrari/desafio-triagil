package com.gabriely.desafiotriagil.controller;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriely.desafiotriagil.dto.TeamDTO;
import com.gabriely.desafiotriagil.dto.mapper.TeamMapper;
import com.gabriely.desafiotriagil.exception.ErrorResponse;
import com.gabriely.desafiotriagil.exception.NegocioException;
import com.gabriely.desafiotriagil.exception.RecordNotFoundException;
import com.gabriely.desafiotriagil.model.Pokemon;
import com.gabriely.desafiotriagil.model.Team;
import com.gabriely.desafiotriagil.model.TeamRequest;
import com.gabriely.desafiotriagil.service.PokeAPIService;
import com.gabriely.desafiotriagil.service.PokemonService;
import com.gabriely.desafiotriagil.service.TeamService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/teams")
@Tag(name = "Teams", description = "Rotas referentes aos times de pokémons")
public class TeamController {

    @Autowired
    protected TeamService teamService;

    @Autowired
    protected PokemonService pokemonService;

    @Autowired
    protected PokeAPIService pokeAPIService;

    @Autowired
    protected TeamMapper teamMapper;

    /* Método/Endpoint que lista todos os times do banco de dados */
    @GetMapping
    /* #region Swagger Settings */
    @Operation(summary = "Retorna lista de todos os times registrados", description = "Descrição", responses = {
            @ApiResponse(description = "A lista de objetos está no atributo result.", content = {
                    @Content(mediaType = "application/json")
            })
    })
    /* #endregion */
    public ResponseEntity<?> list() {
        try {
            List<TeamDTO> teams = teamService.list();

            /* Verifica se existe algum time registrado, se não dispara um erro NOT_FOUND */
            if (teams.isEmpty()) {
                String message = "Nenhum time registrado.";
                System.err.println(message);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
            }
            return ResponseEntity.ok(teams);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }


    /* Método/Endpoint que lista todos os times do banco de dados por um usuário/dono */
    @GetMapping("/{user}")
    /* #region Swagger Settings */
    @Operation(summary = "Retorna o time registrado por usuário", description = "Descrição", responses = {
            @ApiResponse(description = "Lista de teams retoranada", content = {
                    @Content(mediaType = "application/json")
            })
    })
    /* #endregion */
    public ResponseEntity<?> teamByUser(@PathVariable @NotNull String user) {
        try {
            List<Team> teams = teamService.findByOwner(user);

            /* Verifica se existe algum time registrado, se não, responde com status NOT_FOUND */
            if (teams.isEmpty()) {
                String message = "Nenhum time encontrado.";
                System.err.println(message);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message));
            }
            return ResponseEntity.ok(teams);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }


    /* Método/Endpoint que cria um time no banco de dados */
    @PostMapping
	/* #region Swagger Settings */
    @Operation(summary = "Cria um novo Team", responses = {
            @ApiResponse(description = "Team criado", content = {
                    @Content(mediaType = "application/json")
            })
    })
	/* #endregion */
    public ResponseEntity<?> create(
            @Parameter @Valid @RequestBody TeamRequest teamRequest) {
        try {
            Team team = new Team();

            /* Verifica se foi passado o dono do time */
            if (teamRequest.getOwner() == "")
                throw new NegocioException("O time deve ter um dono.");

            team.setOwner(teamRequest.getOwner());

            /* Verifica se foi passado pelo menos um pokémon */
            if (teamRequest.getPokemons().isEmpty())
                throw new NegocioException("O time deve ter pelo menos um pokémon.");

            team.setPokemons(new ArrayList<>());

            Set<String> listPokemonsName = new HashSet<>();
            for (String namePokemon : teamRequest.getPokemons()){
                String namePokemonFormatado = this.formatNamePokemon(namePokemon);



                /* Tenta adicionar o pokémons na lista,
                 * se não conseguir é porque ele já foi adicionado antes e está repetido,
                 * dispara erro.
                 */
                if (!listPokemonsName.add(namePokemonFormatado)) {
                    throw new NegocioException(String.format(
                        "Pokémon %s já está no time e não pode ser repetido.", namePokemon));
                }

                /* Verifica se já existe esse pokémon no banco
                 * Se sim, apenas adiciona ele na lista
                 * Se não, procura as informações na API externa
                 */
                Pokemon pokemonBanco = pokemonService.findByName(namePokemonFormatado);
                if(pokemonBanco != null){
                    team.getPokemons().add(pokemonBanco);
                }else{
                    Pokemon pokemonAPI = pokeAPIService.getPokemon(namePokemonFormatado, namePokemon);
                    team.getPokemons().add(pokemonAPI);
                }
            }
            TeamDTO teamDTO = teamService.create(team);
            return ResponseEntity.ok(teamDTO);
        }catch (NegocioException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Ocorreu um erro: " + e.getMessage()));
        }
    }

    /* Método/Endpoint para encontrar um time no banco de dados pelo seu id */
    @GetMapping("/id/{id}")
    /* #region Swagger Settings */
    @Operation(summary = "Retorna o time pela sua id única", description = "Descrição", responses = {
            @ApiResponse(description = "Team retornado", content = {
                    @Content(mediaType = "application/json")
            })
    })
    /* #endregion */
    public ResponseEntity<?> teamById(@PathVariable @NotNull Long id) {
        try {
            TeamDTO team = teamService.findById(id);
            return ResponseEntity.ok(team);
        } catch (RecordNotFoundException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Ocorreu um erro: " + e.getMessage()));
        }

    }

    /* Método para formatar o nome do pokémon de acordo com a pokéApi */
    private String formatNamePokemon(String namePokemon) {
        namePokemon = namePokemon.toLowerCase();

        namePokemon = Normalizer.normalize(namePokemon, Normalizer.Form.NFD)
                       .replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); // Retirando os acentos

        if (namePokemon.endsWith(".")) {
            namePokemon = namePokemon.substring(0, namePokemon.length() - 1);
        }
        namePokemon = namePokemon.replace(" ", "-");
        namePokemon = namePokemon.replace(".", "-");
        namePokemon = namePokemon.replace("'", "");
        namePokemon = namePokemon.replace(":", "-");
        namePokemon = namePokemon.replace("♀", "-f");
        namePokemon = namePokemon.replace("♂", "-m");

        return namePokemon;
    }
}
