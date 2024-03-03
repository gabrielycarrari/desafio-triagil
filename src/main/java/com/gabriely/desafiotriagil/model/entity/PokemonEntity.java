package com.gabriely.desafiotriagil.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    @Column(name = "id")
    private Long id;

    private String name;

    private Integer height;

    private Integer weight;
}
