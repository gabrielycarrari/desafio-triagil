package com.gabriely.desafiotriagil.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gabriely.desafiotriagil.dto.TeamDTO;
import com.gabriely.desafiotriagil.dto.mapper.TeamMapper;
import com.gabriely.desafiotriagil.exception.NegocioException;
import com.gabriely.desafiotriagil.exception.RecordNotFoundException;
import com.gabriely.desafiotriagil.model.Team;
import com.gabriely.desafiotriagil.repository.TeamRepository;


@Validated
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamService(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public List<TeamDTO> list(){
        return teamRepository.findAll()
            .stream()
            .map(teamMapper::toDTO)
            .collect(Collectors.toList());
    }

    public TeamDTO create(@Valid @NotNull Team team){
        if (team == null) {
            throw new NegocioException("O team não pode ser nulo.");
        }
        return teamMapper.toDTO(teamRepository.save(team));
    }

    // TODO: Verificar se precisa e se está correto
    public TeamDTO update(@NotNull @Positive Long id, @Valid @NotNull TeamDTO team) {
        if (id == null) {
            throw new NegocioException("O campo id não pode ser nulo.");
        }
        return teamRepository.findById(id)
            .map(recordFound-> {
                recordFound.setOwner(team.owner());
                recordFound.setPokemons(team.pokemons());
                return teamMapper.toDTO(teamRepository.save(recordFound));
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public TeamDTO findById(@NotNull @Positive Long id) {
        if (id == null) {
            throw new NegocioException("O campo id não pode ser nulo.");
        }
        return teamRepository.findById(id).map(teamMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Team> findByOwner(String owner){
        return this.teamRepository.findByOwner(owner);
    }

}
