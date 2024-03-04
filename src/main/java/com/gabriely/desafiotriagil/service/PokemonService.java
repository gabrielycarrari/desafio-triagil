package com.gabriely.desafiotriagil.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gabriely.desafiotriagil.dto.PokemonDTO;
import com.gabriely.desafiotriagil.dto.mapper.PokemonMapper;
import com.gabriely.desafiotriagil.exception.RecordNotFoundException;
import com.gabriely.desafiotriagil.model.Pokemon;
import com.gabriely.desafiotriagil.repository.PokemonRepository;

@Validated
@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    private final PokemonMapper pokemonMapper;

    public PokemonService(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
    }

    public List<PokemonDTO> list(){
        return pokemonRepository.findAll()
            .stream()
            .map(pokemonMapper::toDTO)
            .collect(Collectors.toList());
    }

    // public PokemonDTO findById(@NotNull @Positive Long id) {
    //     return pokemonRepository.findById(id).map(pokemonEntityMapper::toEntity)
    //             .orElseThrow(() -> new RecordNotFoundException(id));
    // }


    public PokemonDTO create(@Valid @NotNull PokemonDTO pokemon){
        Pokemon pokemonEntity = pokemonMapper.toEntity(pokemon);
        if (pokemonEntity == null) {
            throw new IllegalStateException("Falha ao converter Pokemon em PokemonEntity.");
        }
        return pokemonMapper.toDTO(pokemonRepository.save(pokemonEntity));
    }


    public PokemonDTO update(@NotNull @Positive Long id, @Valid @NotNull PokemonDTO pokemon) {
        if (id == null) {
            throw new IllegalStateException("O campo id não pode ser nulo.");
        }
        return pokemonRepository.findById(id)
            .map(recordFound-> {
                recordFound.setId(pokemon.id());
                recordFound.setName(pokemon.name());
                recordFound.setHeight(pokemon.height());
                recordFound.setWeight(pokemon.weight());
                return pokemonMapper.toDTO(pokemonRepository.save(recordFound));
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

}
