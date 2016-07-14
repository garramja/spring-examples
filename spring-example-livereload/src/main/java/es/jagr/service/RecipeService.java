package es.jagr.service;

import es.jagr.model.Recipe;

import java.util.List;

/**
 * Recipe service interface
 */
public interface RecipeService {

    List<Recipe> getAll();

}
