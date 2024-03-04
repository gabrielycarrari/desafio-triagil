package com.gabriely.desafiotriagil.dto;

import java.util.List;

import com.gabriely.desafiotriagil.model.Pokemon;

import jakarta.validation.constraints.NotNull;

public record TeamDTO(
        Long id,
        @NotNull String owner,
        @NotNull List<Pokemon> pokemons
) {
}