# Instruções para Iniciar os Containers Docker

Este arquivo fornece instruções mais detalhadas sobre como iniciar os container Docker para este projeto.

## Passos

1. **Instale o Docker:**
  - Caso ainda não tenha o docker instalado em sua máquina, siga as instruções de instalação de acordo com o seu sistema operacional fornecidas pela Docker [aqui](https://docs.docker.com/get-docker/).

2. **Navegue até o diretório**
  - Com o repositório já clonado em sua máquina local, navegue até o diretório raiz do projeto.
  ```bash
    cd desafio-triagil
  ``` 
3.  **Inicie os containers Docker**
  ```bash
    docker-compose up
  ```
4. **Acessar o terminal do container**
  - Após a execução bem-sucedida do comando acima, os containers Docker devem estar em execução. Você pode verificar o status dos containers usando o comando abaixo que listará todos os containers em execução:
  ```bash
    docker ps
  ```
  - Para acessar o terminal do container basta inserir o comando
  ```bash
    docker exec -it desafio-backend /bin/bash
  ```
  - Nota: Ao executar esses comandos, abra um novo terminal e mantenha o terminal que iniciou os containers aberto para garantir o funcionamento correto do ambiente.

---
Qualquer dúvida entre em contato! 👋🏽



[![Static Badge](https://img.shields.io/badge/Gabriely%20Carrari-%230A66C2?logo=linkedIn&link=https%3A%2F%2Fwww.linkedin.com%2Fin%2Fgabriely-carrari%2F)](https://www.linkedin.com/in/gabriely-carrari/)
[![Static Badge](https://img.shields.io/badge/gabrielycarrari%40gmail.com-%23EA4335?logo=gmail&logoColor=white&link=mailto%3Agabrielycarrari%40gmail.com)](mailto:gabrielycarrari@gmail.com)

---
