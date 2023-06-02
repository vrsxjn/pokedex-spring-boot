# Api Pokedex Spring Boot

## Endpoints


**Listar Pokemons**

- Método: `GET`
- URL: `http://localhost:8080/pokedex`

**Registrar Pokemon**

- Método: `POST`
- URL: `http://localhost:8080/pokedex`

**Requisição:**

{
"name": "Pikachu",
"tipo": "Raio"
}

**Deleta Pokemon**

- Método: `DELETE`
- URL: `http://localhost:8080/pokedex/:id`

**Atualizar Pokemon**

- Método: `PUT`
- URL: `http://localhost:8080/pokedex`


**Requisição:**

{
"id": ID
"name": NOVO/ANTIGO,
"tipo": NOVO/ANTIGO
}

**Listar Nomes Pokemon**

- Método: `POST`
- URL: `http://localhost:8080/pokedex/nome/:name`

**Listar Tipo Pokemon**

- Método: `POST`
- URL: `http://localhost:8080/pokedex/tipo/:tipo`
