package es.jagr.service;

import es.jagr.dao.RecipeDao;
import es.jagr.dao.RecipeDaoMap;
import es.jagr.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Recipe service
 */
@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    RecipeDao recipeDao = new RecipeDaoMap();

    @Autowired
    public RecipeServiceImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @Override
    public List<Recipe> getAll() {
        return recipeDao.getAll();
    }

}
