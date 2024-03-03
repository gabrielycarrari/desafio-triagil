package com.gabriely.desafiotriagil.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gabriely.desafiotriagil.model.Pokemon;
import com.gabriely.desafiotriagil.model.entity.PokemonEntity;

@Mapper
public interface PokemonEntityMapper {

    PokemonEntityMapper MAPPER = Mappers.getMapper(PokemonEntityMapper.class);

    PokemonEntity toEntity(Pokemon pokemon);

    Pokemon toModel(PokemonEntity entity);
}
