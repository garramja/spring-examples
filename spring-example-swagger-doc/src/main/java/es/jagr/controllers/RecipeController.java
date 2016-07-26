package es.jagr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.jagr.model.Recipe;
import es.jagr.service.RecipeService;

@RestController
@RequestMapping("recipes")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	/**
	 * GET /recipes - Retrieves all recipes
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Recipe> getAll() {
		return recipeService.getAll();
	}

	/**
	 * GET /recipes/{id} - Retrieves a specific recipe
	 *
	 * @param id
	 *            The id
	 * @return Recipe
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Recipe getById(@PathVariable String id) {
		return recipeService.getById(id);
	}

	/**
	 * POST /recipes - Insert a new recipe
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insert(@RequestBody Recipe recipe) {
		recipeService.insert(recipe);
	}

	/**
	 * PUT /recipes/{id} - Updates recipe with specific {id}
	 *
	 * @param id
	 *            The id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable String id, @RequestBody Recipe recipe) {
		recipeService.update(id, recipe);
	}

	/**
	 * DELETE /recipes/{id} - Deletes recipe with specific {id}
	 *
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		recipeService.delete(id);
	}

}
