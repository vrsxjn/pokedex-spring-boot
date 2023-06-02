package com.example.pokedex.repository;

import com.example.pokedex.model.Pokemon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
  
  List<Pokemon> findByTipo(String tipo);
  List<Pokemon> findByName(String name);
}