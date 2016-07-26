package es.jagr.service;

import java.util.List;

import es.jagr.model.Recipe;

/**
 * Recipe service interface
 */
public interface RecipeService {

    Recipe getById(String id);

    List<Recipe> getAll();

    void delete(String id);

    void insert(Recipe recipe);

    void update(String id, Recipe recipe);
}
