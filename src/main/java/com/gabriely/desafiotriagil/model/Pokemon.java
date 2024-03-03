package com.gabriely.desafiotriagil.model;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class Pokemon {

    // @Schema(hidden = true)
	private Long id;

    @NotEmpty(message = "O campo name é obrigatório.")
    @NotBlank(message = "O campo name não pode ser vazio.")
    @Schema(
        description = "Nome do pokemon",
        name = "nome",
        type = "String",
        example = "pikachu"
    )
    private String name;

    // @Schema(hidden = true)
    private Integer height;

    // @Schema(hidden = true)
    private Integer weight;

}
