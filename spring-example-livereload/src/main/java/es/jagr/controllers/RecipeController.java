package es.jagr.controllers;

import java.util.Collections;
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

        List<Recipe> recipeList = recipeService.getAll();

        //Uncomment to try livereload
//        Collections.reverse(recipeList);
        return recipeList;
	}

}
