package com.gabriely.desafiotriagil.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // TODO: verificar isso
    private Long id;

    @NotEmpty(message = "O campo owner é obrigatório.")
    @NotBlank(message = "O campo owner não pode ser vazio.")
    @Column(length = 50, nullable = false)
    private String owner;

    @NotEmpty(message = "A lista de pokémons é obrigatória.")
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "team_pokemon",
        joinColumns = { @JoinColumn(name = "team_id") },
        inverseJoinColumns = { @JoinColumn(name = "pokemon_id") }
    )
    private List<Pokemon> pokemons;


}
