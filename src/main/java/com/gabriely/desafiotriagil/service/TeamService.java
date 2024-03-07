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

    /**
     * Método que lista todos os times do banco de dados
     * @return Lista de todos os times do banco
     */
    public List<TeamDTO> list(){
        return teamRepository.findAll()
            .stream()
            .map(teamMapper::toDTO)
            .collect(Collectors.toList());
    }

    /**
     * Método para criar um time no banco de dados
     * @param team - time a ser criado
     * @return Team criado
     * @throws NegocioException - Exceção lançada quando o team é null
     */
    public TeamDTO create(@Valid @NotNull Team team){
        if (team == null) {
            throw new NegocioException("O team não pode ser nulo.");
        }
        return teamMapper.toDTO(teamRepository.save(team));
    }

    /**
     * Método para encontrar um time no banco de dados pelo seu id
     * @param id - id do time
     * @return Team encontrado
     * @throws NegocioException - Exceção lançada quando o campo id é null
     * @throws RecordNotFoundException - Exceção lançada quando o time não é encontrado
     */
    public TeamDTO findById(@NotNull @Positive Long id) {
        if (id == null) {
            throw new NegocioException("O campo id não pode ser nulo.");
        }
        return teamRepository.findById(id).map(teamMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    /**
     * Método para encontrar todos os times do banco de dados por um usuário/dono
     * @param owner - dono do time
     * @return Lista com os times encontrados
     */
    public List<Team> findByOwner(String owner){
        return this.teamRepository.findByOwner(owner);
    }

}
