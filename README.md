# Desafio Triágil - API de Times de Pokémon

Este repositório contém uma solução para o desafio proposto pela Triágil, que tem como objetivo testar os conhecimentos em programação, bem como a capacidade de utilizar recursos online. Esta solução consiste no desenvolvimento de uma API utilizando o framework Spring Boot para criar e gerenciar times de Pokémon, consumindo a API externa [pokeapi.co](https://pokeapi.co/).

## Funcionalidades da API

1. **Criar Time de Pokémon:**
   - Endpoint: `/criar_time` //TODO: ajustar endpoint
   - Método: `POST`
   - Parâmetros:
     - Lista de Pokémon
     - Nome de Usuário
   - Descrição: Recebe uma lista de Pokémon e um nome de usuário, busca as informações sobre esses Pokémon na pokeAPI e salva o time. Retorna uma mensagem de validação e uma ID única para identificar o time.
   - Exemplo: //TODO

2. **Listar Todos os Times Registrados:**
   - Endpoint: `/times` //TODO: ajustar endpoint
   - Método: `GET`
   - Descrição: Retorna todos os times de Pokémon registrados na API.
   - Exemplo: //TODO

3. **Listar Todos os Times por Usuário** //TODO

4. **Buscar Time por ID Única:**
   - Endpoint: `/time/{id}` //TODO: ajustar endpoint
   - Método: `GET`
   - Parâmetros:
     - ID única do time
   - Descrição: Retorna as informações de um time específico com base na sua ID única.
   - Exemplo: //TODO

## Instruções para Execução

1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/gabrielycarrari/desafio-triagil.git
   ```
2. **Dockerfile e Compose:**
   - O Dockerfile e o docker-compose.yml estão incluídos no repositório para facilitar a implantação da API em contêineres Docker. Certifique-se de ter o Docker instalado em sua máquina e execute os comandos apropriados para construir e implantar os contêineres.
   - O repositório também está configurado para uso com DevContainer.
   - O projeto inclui dois contêiners Docker:
     - **desafio-backend**: API desenvolvida em Java com Spring Boot e Maven, rodando na porta 8181.
     - **desafio-postgres**: banco de dados PostgreSQL, cujo nome do banco é "desafiodb", rodando na porta 5433.

3. **Instalar as dependências** //TODO

4. **Executar a Aplicação:** //TODO

5. **Acessar a API:**
   - Após a execução, a API estará disponível em `http://localhost:8181`.

6. **Testar a API:** //TODO


## Observações

- Esta solução foi desenvolvida por Gabriely Machado Carrari, como resposta ao desafio proposto pela Triágil.
- Para mais detalhes sobre o desafio, acesse o [link do desafio](https://github.com/triagilbr/desafio-triagil).
- Qualquer dúvida ou problema com a solução, entre em contato via gabrielycarrari@gmail.com.
