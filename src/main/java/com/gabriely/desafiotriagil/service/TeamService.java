package com.gabriely.desafiotriagil.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gabriely.desafiotriagil.exception.RecordNotFoundException;
import com.gabriely.desafiotriagil.model.Team;
import com.gabriely.desafiotriagil.model.entity.TeamEntity;
import com.gabriely.desafiotriagil.model.mapper.PokemonEntityMapper;
import com.gabriely.desafiotriagil.model.mapper.TeamEntityMapper;
import com.gabriely.desafiotriagil.repository.TeamRepository;


@Validated
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamEntityMapper teamEntityMapper;

    @Autowired
    private PokemonEntityMapper pokemonEntityMapper;

    public List<Team> list(){
        return teamRepository.findAll()
            .stream()
            .map(teamEntityMapper::toModel)
            .collect(Collectors.toList());
    }

    // public TeamEntity findById(@NotNull @Positive Long id) {
    //     return teamRepository.findById(id).map(teamEntityMapper::toEntity)
    //             .orElseThrow(() -> new RecordNotFoundException(id));
    // }

    public Team create(@Valid @NotNull Team team){
        //Força o id para null
        team.setId(null);

        TeamEntity teamEntity = teamEntityMapper.toEntity(team);
        if (teamEntity == null) {
            throw new IllegalStateException("Falha ao converter Team em TeamEntity.");
        }
        return teamEntityMapper.toModel(teamRepository.save(teamEntity));
    }

    public Team update(@NotNull @Positive Long id, @Valid @NotNull Team team) {
        if (id == null) {
            throw new IllegalStateException("O campo id não pode ser nulo.");
        }
        return teamRepository.findById(id)
            .map(recordFound-> {
                recordFound.setOwner(team.getOwner());
                recordFound.setPokemons(team.getPokemons().stream()
                    .map(pokemonEntityMapper::toEntity)
                    .collect(Collectors.toList()));
                return teamEntityMapper.toModel(teamRepository.save(recordFound));
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

}
