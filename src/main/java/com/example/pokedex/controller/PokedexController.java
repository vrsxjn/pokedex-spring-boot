package com.example.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.pokedex.model.Pokemon;
import com.example.pokedex.repository.PokemonRepository;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {
  
  @Autowired
  private PokemonRepository pokemonRepository;

  // Get Lista - Pega todos os pokemons registrado na pokedex
  @GetMapping
  public List<Pokemon> list() {
   return pokemonRepository.findAll();
  }

  // Post criar - Registrar um pokemon na pokedex
  @PostMapping
  @ResponseBody
  public ResponseEntity<String> adcionar(@RequestBody Pokemon pokemon) {
    String response = "{\"data\": {\"message\": \"Pokemon Adicionado\"}}";

    pokemonRepository.save(pokemon);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // Put Editar - Editar um pokemon na pokedex passando o "id": 1
  @PutMapping
  @ResponseBody
  public ResponseEntity<String> atualizar(@RequestBody Pokemon pokemon) {
    if(pokemon.getId() == null) {
      return ResponseEntity.badRequest().body("{\"data\": {\"message\": \"Id Pokemon Obrigatorio\"}}");
    }
    pokemonRepository.save(pokemon);
    return ResponseEntity.ok("{\"data\": {\"message\": \"Pokemon Atualizado\"}}");

  }

  // Delete Deletar - Deletar pokemon da pokedex
  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<String> remover(@PathVariable("id") Long id) {
    String response = "{\"data\": {\"message\": \"Pokemon Removido\"}}";

    pokemonRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body(response);

  }

  // Get Listar - Buscar pokemon no /nome/NOMEPOKEMON 
  @GetMapping("/nome/{pokemon}")
  public List<Pokemon> buscarPokemon(@PathVariable("pokemon") String name) {
    return pokemonRepository.findByName(name);
  };

  // Get Listar - Buscar tipo pokemon no /tipo/TIPOPOKEMON
  @GetMapping("/tipo/{tipo}")
  public List<Pokemon> buscarTipo(@PathVariable("tipo") String tipo) {
    return pokemonRepository.findByTipo(tipo);
  }


}
