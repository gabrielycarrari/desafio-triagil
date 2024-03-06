package com.gabriely.desafiotriagil.dto;

import java.util.List;

import com.gabriely.desafiotriagil.model.Pokemon;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record TeamDTO(
        @Hidden Long id,

        @Schema(
            description = "Nome do dono do time",
            name = "owner",
            type = "String",
            example = "gabriely"
        )
        @NotNull String owner,

        @Schema(
            description = "Lista de pokémons",
            name = "pokemons",
            type = "JSON",
            example = "[\n" +
                      "  \"pikachu\",\n" +
                      "  \"blastoise\",\n" +
                      "  \"dragonite\"\n" +
                      "]"
        )
        @NotNull List<Pokemon> pokemons
) {
}