# Desafio Triágil - API de Times de Pokémon

Este repositório contém uma solução para o desafio proposto pela Triágil, que tem como objetivo testar os conhecimentos em programação, bem como a capacidade de utilizar recursos online. Esta solução consiste no desenvolvimento de uma API utilizando o Java Spring Framework (Spring Framework) e a ferramenta Java Spring Boot (Spring Boot) para criar e gerenciar times de Pokémon, consumindo a API externa [pokeapi.co](https://pokeapi.co/).

## ⚙️ Funcionalidades da API

1. **Criar Time de Pokémon:**
   - Endpoint: `/api/teams`
   - Método: `POST`
   - Parâmetros:
     - Lista de Pokémon
     - Nome de Usuário/Dono
   - Descrição: Recebe uma lista de Pokémon e um nome de usuário/dono, busca as informações sobre esses Pokémon no banco de dados e na pokeAPI e salva o time. Retorna uma mensagem de validação e uma ID única para identificar o time.
   - Exemplo: //TODO

2. **Listar Todos os Times Registrados:**
   - Endpoint: `/api/teams`
   - Método: `GET`
   - Descrição: Retorna todos os times de Pokémon registrados na API.
   - Exemplo: //TODO

3. **Listar Todos os Times por Usuário**
   - Endpoint: `/api/teams/{user}`
   - Método: `GET`
   - Parâmetro:
     - Nome de Usuário/Dono
   - Descrição: Retorna todos os times de Pokémon registrados na API por um usuário/dono.
   - Exemplo: //TODO

4. **Buscar Time por ID Única:**
   - Endpoint: `api/teams/id/{id}`
   - Método: `GET`
   - Parâmetros:
     - ID única do time
   - Descrição: Retorna as informações de um time específico com base na sua ID única.
   - Exemplo: //TODO
---


## 🚀 Instruções para Execução

1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/gabrielycarrari/desafio-triagil.git
   ```
   
2. **Dockerfile e Compose:**
   - O Dockerfile e o docker-compose.yml estão incluídos no repositório para facilitar a implantação da API em contêineres Docker. Certifique-se de ter o Docker instalado em sua máquina e execute os comandos apropriados para construir e implantar os contêineres.
   - O repositório também está configurado para uso com Dev Containers, uma extensão do Visual Studio Code que permite o uso de um contêiner Docker como um ambiente de desenvolvimento.
      - Para usá-lo, basta instalar a extensão Dev Containers e usar a opção "Open Folder in Container" com a pasta na qual o projeto foi clonado. Com isso, o container será criado ou iniciado automaticamente.
      - Certifique-se de que o Docker Desktop esteja instalado e em execução em sua máquina antes de iniciar o Dev Containers.
   - O projeto inclui dois contêiners Docker:
     - **desafio-backend**: API desenvolvida em Java com Spring Boot e Maven, rodando na porta 8181.
     - **desafio-postgres**: banco de dados PostgreSQL, cujo nome do banco é "desafiodb", rodando na porta 5433.


3. **Instalar as dependências**
   - Caso seja a primeira execução instale as dependências pelo terminal:
     
      ```bash
      mvn install
      ```

4. **Executar a Aplicação e Acessar a API**
   - Feito isso, basta executar a aplicação.
   - A API estará disponível em `http://localhost:8181`.


5. **Testar a API:**
   - Para testar os endpoints da API você pode utilizar ferramentas populares, tais como Postman, cURL e Insomnia.
   - Além disso, o projeto está integrado com o Swagger, uma ferramenta de documentação e teste de API.
      - Ele vai fornecer uma interface interativa com detalhes sobre cada endpoint, parâmetros necessários e exemplos de solicitações para testar e entender o comportamento da API.
      - Para utilizá-la basta acessar [http://localhost:8181/swagger-ui/index.html](http://localhost:8181/swagger-ui/index.html),
---

## 💻 Exemplos
#### Criar Time (input): /api/teams //TODO

#### Listar Todos os Times (output): /api/teams //TODO

#### Listar Todos os Times por Usuário (output): /api/teams/{user} //TODO

#### Buscar Time por ID Única (output): /api/teams/id/{id} //TODO
---

## 📝 Observações

- Esta solução foi desenvolvida por Gabriely Machado Carrari, como resposta ao desafio proposto pela Triágil.
- Para mais detalhes sobre o desafio, acesse o [link do desafio](https://github.com/triagilbr/desafio-triagil).
- Qualquer dúvida ou problema com a solução, entre em contato via gabrielycarrari@gmail.com.
---
   
## 👩‍💻 Autora 
  <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/73599857?v=4" width="100px;" alt=""/>
 

Feito com ❤️ por Gabriely Machado Carrari </br>
Entre em contato! 👋🏽



[![Static Badge](https://img.shields.io/badge/Gabriely%20Carrari-%230A66C2?logo=linkedIn&link=https%3A%2F%2Fwww.linkedin.com%2Fin%2Fgabriely-carrari%2F)](https://www.linkedin.com/in/gabriely-carrari/)
[![Static Badge](https://img.shields.io/badge/gabrielycarrari%40gmail.com-%23EA4335?logo=gmail&logoColor=white&link=mailto%3Agabrielycarrari%40gmail.com)](mailto:gabrielycarrari@gmail.com)

---

## 📃 Licença //TODO
Esse repositório está licenciado pela MIT LICENSE. Para mais informações detalhadas, leia o arquivo LICENSE contido nesse repositório.
