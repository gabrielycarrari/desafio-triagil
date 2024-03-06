package com.gabriely.desafiotriagil.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    @Schema(
            description = "Nome do dono do time",
            name = "owner",
            type = "String",
            example = "gabriely"
        )
    private String owner;
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
    private List<String> pokemons;
}
