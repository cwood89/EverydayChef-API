package com.everydaychef.main.repository;

import com.everydaychef.main.model.Recipe;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
  Recipe findByUrl(String url);
}