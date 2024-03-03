package com.gabriely.desafiotriagil.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gabriely.desafiotriagil.model.Team;
import com.gabriely.desafiotriagil.model.entity.TeamEntity;

@Mapper
public interface TeamEntityMapper {

    TeamEntityMapper MAPPER = Mappers.getMapper(TeamEntityMapper.class);

    TeamEntity toEntity(Team team);

    Team toModel(TeamEntity entity);
}
