package es.jagr.dao;

import java.util.List;

import es.jagr.model.Recipe;

/**
 * Recipe DAO Interface
 */
public interface RecipeDao {

	List<Recipe> getAll();

}
