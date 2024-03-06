package com.gabriely.desafiotriagil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriely.desafiotriagil.exception.NegocioException;
import com.gabriely.desafiotriagil.model.Pokemon;

@Service
public class PokeAPIService {

    @Value("${pokeapi.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // TODO: add comentários
    public Pokemon getPokemon(String name) {
        String urlPokemon = url + "/pokemon/" + name;
        try {
            String json = restTemplate.getForObject(urlPokemon, String.class);
            Pokemon pokomonApi = objectMapper.readValue(json, Pokemon.class);
            return pokomonApi;
        } catch (HttpClientErrorException.NotFound e) {
            throw new NegocioException("Pokemon " + name + " não encontrado!");
        }catch (Exception e){
            throw new NegocioException("Ocorreu um erro: " + e.getMessage());
        }
    }
}
