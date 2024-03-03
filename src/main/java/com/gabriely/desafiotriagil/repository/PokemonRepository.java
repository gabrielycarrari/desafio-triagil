package com.gabriely.desafiotriagil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriely.desafiotriagil.model.entity.PokemonEntity;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long>{

}
