package com.gabriely.desafiotriagil.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gabriely.desafiotriagil.dto.PokemonDTO;
import com.gabriely.desafiotriagil.dto.mapper.PokemonMapper;
import com.gabriely.desafiotriagil.exception.NegocioException;
import com.gabriely.desafiotriagil.model.Pokemon;
import com.gabriely.desafiotriagil.repository.PokemonRepository;

@Validated
@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    private final PokemonMapper pokemonMapper;

    public PokemonService(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
    }

    /**
     * Método que lista todos os pokémons do banco de dados
     * @return Lista de todos os pokémons do banco
     */
    public List<PokemonDTO> list(){
        return pokemonRepository.findAll()
            .stream()
            .map(pokemonMapper::toDTO)
            .collect(Collectors.toList());
    }


    /**
     * Método para criar um pokémon no banco de dados
     * @param pokemon - pokémon a ser criado
     * @return Pokemon criado
     * @throws NegocioException - Exceção lançada quando o pokémon está vazio
     */
    public PokemonDTO create(@Valid @NotNull Pokemon pokemon){
        if (pokemon == null) {
            throw new NegocioException("O pokemon não pode estar vazio.");
        }
        return pokemonMapper.toDTO(pokemonRepository.save(pokemon));
    }

    /**
     * Método para encontrar um pokémon no banco de dados pelo seu nome
     * @param name - nome do pokémon a ser buscado
     * @return Pokemon encontrado no banco de dados
     */
    public Pokemon findByName(String name){
        return this.pokemonRepository.findByName(name);
    }

}
