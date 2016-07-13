package es.jagr.config;

import es.jagr.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by javier.garcia on 13/07/2016.
 */
@SpringBootApplication
@ComponentScan("es.jagr.*")
public class Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final String REST_URL = "http://localhost:8090";
    private static final String REST_CONTEXT = "/recipes/";
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {

        Recipe recipe = new Recipe("hdo", "Hot dog", 5);

        //Insert
        LOG.info("#### Insert new Hot dog Recipe");
        restTemplate.postForLocation(REST_URL + REST_CONTEXT, recipe);

        //Get by id
        LOG.info("#### Getting Hot dog recipe");
        Recipe recipeFromApi = restTemplate.getForObject(REST_URL + REST_CONTEXT + recipe.getId(), Recipe.class);
        LOG.info("#### " + recipeFromApi.toString());

        //Update
        LOG.info("#### Update Hot dog recipe to add ketchup");
        recipe.setName("Hot dog with ketchup");
        restTemplate.put(REST_URL + REST_CONTEXT + recipe.getId(), recipe);

        //Get all
        LOG.info("#### Getting all recipes");
        getAllRecipes();

        //Delete
        LOG.info("#### Delete Hot dog recipe ");
        restTemplate.delete(REST_URL + REST_CONTEXT + "/hdo");
        LOG.info("#### Getting all recipes");
        getAllRecipes();

    }

    private void getAllRecipes() {
        Recipe[] recipes = restTemplate.getForObject(REST_URL + REST_CONTEXT, Recipe[].class);

        for (Recipe recipe: Arrays.asList(recipes)) {
            LOG.info("#### " + recipe.toString());
        }
    }

}
