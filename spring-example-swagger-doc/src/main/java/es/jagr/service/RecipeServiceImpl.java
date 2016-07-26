package es.jagr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jagr.dao.RecipeDao;
import es.jagr.dao.RecipeDaoMap;
import es.jagr.model.Recipe;

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
    public Recipe getById(String id) {
        return recipeDao.getById(id);
    }

    @Override
    public List<Recipe> getAll() {
        return recipeDao.getAll();
    }

    @Override
    public void delete(String id) {
        recipeDao.delete(id);
    }

    @Override
    public void insert(Recipe recipe) {
        recipeDao.insert(recipe);
    }

    @Override
    public void update(String id, Recipe recipe) {
        recipeDao.update(id, recipe);
    }

}
