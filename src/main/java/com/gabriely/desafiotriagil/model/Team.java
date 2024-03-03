package com.gabriely.desafiotriagil.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class Team {

    private Long id;

    @NotEmpty(message = "O campo owner é obrigatório.")
    @NotBlank(message = "O campo owner não pode ser vazio.")
    @Schema(
        description = "Nome do dono do time",
        name = "nome",
        type = "String",
        example = "gabriely"
    )
    private String owner;

    //@JsonFilter("listPokemons")
    @NotEmpty(message = "A lista de pokémons é obrigatória.")
    @NotBlank(message = "A lista de pokémons não pode ser vazia.")
    @Schema(
        description = "Lista de pokémons",
        name = "pokemons",
        type = "JSON",
        example = "[{\"pikachu\",\r\n" + //
                    "\"blastoise\",\r\n" + //
                    "\"dragonite\",}]"
    )
    // @Schema(
    //     description = "Lista de pokémons",
    //     name = "pokemons",
    //     type = "JSON",
    //     example = "[{\"id\": 25,\r\n" + //
    //                 "\"name\": \"pikachu\",\r\n" + //
    //                 "\"weight\": 60,\r\n" + //
    //                 "\"height\": 4}]"
    // )
    private List<Pokemon> pokemons;


}