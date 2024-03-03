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
import com.gabriely.desafiotriagil.model.Pokemon;
import com.gabriely.desafiotriagil.model.entity.PokemonEntity;
import com.gabriely.desafiotriagil.model.mapper.PokemonEntityMapper;
import com.gabriely.desafiotriagil.repository.PokemonRepository;

@Validated
@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonEntityMapper pokemonEntityMapper;

    public List<Pokemon> list(){
        return pokemonRepository.findAll()
            .stream()
            .map(pokemonEntityMapper::toModel)
            .collect(Collectors.toList());
    }

    // public PokemonEntity findById(@NotNull @Positive Long id) {
    //     return pokemonRepository.findById(id).map(pokemonEntityMapper::toEntity)
    //             .orElseThrow(() -> new RecordNotFoundException(id));
    // }

    public Pokemon create(@Valid @NotNull Pokemon pokemon){
        //Força o id para null
        pokemon.setId(null);

        PokemonEntity pokemonEntity = pokemonEntityMapper.toEntity(pokemon);
        if (pokemonEntity == null) {
            throw new IllegalStateException("Falha ao converter Pokemon em PokemonEntity.");
        }
        return pokemonEntityMapper.toModel(pokemonRepository.save(pokemonEntity));
    }

    
    public Pokemon update(@NotNull @Positive Long id, @Valid @NotNull Pokemon pokemon) {
        if (id == null) {
            throw new IllegalStateException("O campo id não pode ser nulo.");
        }
        return pokemonRepository.findById(id)
            .map(recordFound-> {
                recordFound.setId(pokemon.getId());
                recordFound.setName(pokemon.getName());
                recordFound.setHeight(pokemon.getHeight());
                recordFound.setWeight(pokemon.getWeight());
                return pokemonEntityMapper.toModel(pokemonRepository.save(recordFound));
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

}
