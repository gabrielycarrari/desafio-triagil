package com.gabriely.desafiotriagil.dto.mapper;

import org.springframework.stereotype.Component;

import com.gabriely.desafiotriagil.dto.TeamDTO;
import com.gabriely.desafiotriagil.model.Team;

@Component
public class TeamMapper {
    public TeamDTO toDTO(Team team) {
        if (team == null){
            return null;
        }
        return new TeamDTO(
            team.getId(),
            team.getOwner(),
            team.getPokemons());
    }

    public Team toEntity(TeamDTO teamDTO) {
        if (teamDTO == null) {
            return null;
        }

        Team team = new Team();
        if (teamDTO.id() != null){
            team.setId(teamDTO.id());
        }
        team.setOwner(teamDTO.owner());
        team.setPokemons(teamDTO.pokemons());

        return team;
    }
}
