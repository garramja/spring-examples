package es.jagr.dao;

import java.util.List;

import es.jagr.model.Recipe;

/**
 * Recipe DAO Interface
 */
public interface RecipeDao {

	Recipe getById(String id);

	List<Recipe> getAll();

	void delete(String id);

	void insert(Recipe recipe);

	void update(String id, Recipe recipe);
}
