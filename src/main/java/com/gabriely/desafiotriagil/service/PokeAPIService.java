package com.gabriely.desafiotriagil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriely.desafiotriagil.exception.NegocioException;
import com.gabriely.desafiotriagil.model.Pokemon;

/**
 * Serviço que faz a consulta na pokéAPI
 */
@Service
public class PokeAPIService {

    @Value("${pokeapi.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

   /**
     * Método que busca o pokémon na pokéAPI pelo seu nome
     * @param name - nome do pokémon a ser buscado
     * @return Pokemon com o id, name, height e weight encontrado na API
     * @throws HttpClientErrorException.NotFound - Exceção lançada quando o pokémon não é encontrado
     * @throws Exception - Exceção lançada quando ocorre outros erros
     */
    public Pokemon getPokemon(String name) {
        String urlPokemon = url + "/pokemon/" + name;

        try {
            String json = restTemplate.getForObject(urlPokemon, String.class);
            Pokemon pokomonApi = objectMapper.readValue(json, Pokemon.class);
            return pokomonApi;
        } catch (HttpClientErrorException.NotFound e) {
            throw new NegocioException("Pokémon " + name + " não encontrado!");
        }catch (Exception e){
            throw new NegocioException("Ocorreu um erro: " + e.getMessage());
        }
    }
}
