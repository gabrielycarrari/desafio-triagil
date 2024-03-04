package com.gabriely.desafiotriagil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriely.desafiotriagil.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
