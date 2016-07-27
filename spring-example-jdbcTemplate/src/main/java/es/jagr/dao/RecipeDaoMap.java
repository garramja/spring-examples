package es.jagr.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import es.jagr.model.Recipe;

/**
 * Recipe Map in memory
 */
@Repository
@Profile("dev")
public class RecipeDaoMap implements RecipeDao {

    private static Map<String, Recipe> recipesById = new HashMap<String, Recipe>();

    static {
        Recipe recipe = new Recipe("spo", "Spanish omelete", 4);
        recipesById.put(recipe.getId(), recipe);

        recipe = new Recipe("pae", "Paella", 5);
        recipesById.put(recipe.getId(), recipe);

        recipe = new Recipe("coc", "Cocido Madrileño", 3);
        recipesById.put(recipe.getId(), recipe);
    }

    @Override
    public Recipe getById(String id) {
        return recipesById.get(id);
    }

    @Override
    public List<Recipe> getAll() {
        return new ArrayList<Recipe>(recipesById.values());
    }

    @Override
    public void delete(String id) {
        recipesById.remove(id);
    }

    @Override
    public void insert(Recipe recipe) {
        recipesById.put(recipe.getId(), recipe);
    }

    @Override
    public void update(String id, Recipe recipe) {
        recipesById.remove(id);
        recipesById.put(id, recipe);
    }

}
