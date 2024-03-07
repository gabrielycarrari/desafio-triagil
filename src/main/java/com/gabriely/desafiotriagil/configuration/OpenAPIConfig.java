package com.gabriely.desafiotriagil.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

/* Arquivo de configuração do Swagger */
@Configuration
public class OpenAPIConfig {

  @Value("${server.url}")
  private String url;


  @Bean
  public OpenAPI myOpenAPI() {
    Server server = new Server();
    server.setUrl(url);
    server.setDescription("Server URL in Development environment");


    Contact contact = new Contact();
    contact.setEmail("gabrielycarrari@gmail.com");
    contact.setName("Gabriely Machado Carrari");
    contact.setUrl("https://github.com/gabrielycarrari/desafio-triagil");


    Info info = new Info()
        .title("API Desafio Triágil")
        .version("1.0")
        .contact(contact)
        .description("Essa API foi desenvolvida como resposta ao desafio proposto pela Triágil para uma vaga de estágio. "
                    + "Ela permite criar e gerenciar times de Pokémon, utilizando a pokeAPI para obter informações sobre os Pokémon.");


    return new OpenAPI().info(info).servers(List.of(server));
  }
}
