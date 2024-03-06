package com.gabriely.desafiotriagil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriely.desafiotriagil.model.Pokemon;
import com.gabriely.desafiotriagil.service.PokemonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pokemons")
@Tag(name = "Pokemons", description = "Rotas referentes aos pokémons")
public class PokemonController {

    @Autowired
    protected PokemonService pokemonService;

    @GetMapping
    /* #region Swagger Settings */
    @Operation(summary = "Retorna lista de objetos dessa entidade", description = "Descrição", responses = {
            @ApiResponse(description = "A lista de objetos está no atributo result.", content = {
                    @Content(mediaType = "application/json")
            })
    })
    /* #endregion */
    public List<Pokemon> list() {
        System.out.println("teste");
        return null;

    }

}
