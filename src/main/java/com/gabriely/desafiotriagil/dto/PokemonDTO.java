package com.gabriely.desafiotriagil.dto;

import jakarta.validation.constraints.NotNull;

public record PokemonDTO(
        Long id,
        @NotNull String name,
        @NotNull int height,
        @NotNull int weight
) {
}