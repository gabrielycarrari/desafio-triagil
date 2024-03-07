package com.gabriely.desafiotriagil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gabriely.desafiotriagil.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

    @Transactional(readOnly = true)
    Pokemon findByName(String name);
}
