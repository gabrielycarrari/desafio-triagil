package com.gabriely.desafiotriagil.dto.mapper;

import org.springframework.stereotype.Component;

import com.gabriely.desafiotriagil.dto.PokemonDTO;
import com.gabriely.desafiotriagil.model.Pokemon;


@Component
public class PokemonMapper {
    public PokemonDTO toDTO(Pokemon pokemon) {
        if (pokemon == null){
            return null;
        }
        return new PokemonDTO(
            pokemon.getId(),
            pokemon.getName(),
            pokemon.getHeight(),
            pokemon.getWeight());
    }

    public Pokemon toEntity(PokemonDTO pokemonDTO) {
        if (pokemonDTO == null) {
            return null;
        }

        Pokemon pokemon = new Pokemon();
        if (pokemonDTO.id() != null){
            pokemon.setId(pokemonDTO.id());
        }
        pokemon.setName(pokemonDTO.name());
        pokemon.setHeight(pokemonDTO.height());
        pokemon.setWeight(pokemonDTO.weight());

        return pokemon;
    }
}
