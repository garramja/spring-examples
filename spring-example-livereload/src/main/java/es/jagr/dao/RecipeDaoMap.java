package es.jagr.dao;

import es.jagr.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Recipe Map in memory
 */
@Repository
public class RecipeDaoMap implements RecipeDao {

    private static Map<String, Recipe> recipesById = new HashMap<String, Recipe>();

    static {
        Recipe recipe = new Recipe("spo", "Spanish omelete", 4);
        recipesById.put(recipe.getId(), recipe);

        recipe = new Recipe("pae", "Paella", 5);
        recipesById.put(recipe.getId(), recipe);

        recipe = new Recipe("coc", "Cocido Madrileño", 3);
        recipesById.put(recipe.getId(), recipe);

        //Uncomment to test live reload
//        recipe = new Recipe("hdo", "Hot dog", 3);
//        recipesById.put(recipe.getId(), recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return new ArrayList<Recipe>(recipesById.values());
    }

}
