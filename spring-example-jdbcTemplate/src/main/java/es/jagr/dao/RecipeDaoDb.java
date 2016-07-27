package es.jagr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.jagr.model.Recipe;

/**
 * Created by javier.garcia on 27/07/2016.
 */
@Repository
@Profile("stg")
public class RecipeDaoDb implements RecipeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Recipe getById(String id) {

        return jdbcTemplate.queryForObject(
                "SELECT ID FROM RECIPES WHERE ID = ?"
                , BeanPropertyRowMapper.newInstance(Recipe.class)
                , id);
    }

    @Override
    public List<Recipe> getAll() {

        return jdbcTemplate.query(
                "SELECT * FROM RECIPES"
                , new BeanPropertyRowMapper(Recipe.class));
    }

    @Override
    public void delete(String id) {

        jdbcTemplate.update(
                "DELETE FROM RECIPES WHERE ID = ? "
                , id);
    }

    @Override
    public void insert(Recipe recipe) {

        jdbcTemplate.update(
                "INSERT INTO RECIPES VALUES(?,?,?) "
                , recipe.getId()
                , recipe.getName()
                , recipe.getStars());
    }

    @Override
    public void update(String id, Recipe recipe) {

        jdbcTemplate.update(
                "UPDATE RECIPES SET NAME = ?, STARS = ? WHERE ID = ? "
                , recipe.getName()
                , recipe.getStars()
                , recipe.getId());
    }
}
