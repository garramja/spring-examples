# spring-example-swagger-doc
This example show how springfox help us to generate rest api documentation automatically. 
This methods are:
* GET /recipes - Retrieves all recipes
* GET /recipes/{id} - Retrieves a specific recipe
* POST /recipes - Insert a new recipe
* PUT /recipes/{id} - Updates recipe with specific {id}
* DELETE /recipes/{id} - Deletes recipe with specific {id}

## Project structure
The project structure is like spring-example-rest-service on this serie of exmaples.

## Add auto generate swagger documentation
We need add springfox dependencies and inject @Bean on SpronBootApplication class configuration.

>		<dependency>
>            <groupId>io.springfox</groupId>
>            <artifactId>springfox-swagger2</artifactId>
>            <version>2.5.0</version>
>        </dependency>
>        <dependency>
>            <groupId>io.springfox</groupId>
>            <artifactId>springfox-swagger-ui</artifactId>
>            <version>2.5.0</version>
>        </dependency>


>	@Bean
>	public Docket recipeApi() {
>		ApiInfo apiInfo = new ApiInfo("API recipe example","1.0.0","1.0.0","Licencia","Javier García <javier.garcia@sm2baleares.es>","API recipe","");
>		return new Docket(DocumentationType.SWAGGER_2)
>				.apiInfo(apiInfo)
>               .groupName("API recipe")
>                .select()
>                .apis(RequestHandlerSelectors.any())
>                .paths(PathSelectors.any())
>                .build()
>                .pathMapping("/")
>				.tags(new Tag("Recipe service", "All services for recipe API"))
>				.enableUrlTemplating(true);
>	}


## Starting application
Default port is configured to 8090. You are able to change on  > spring-example-rest-service\src\main\resources\application.properties

#### Running from IDE (used intelliJ, but you can use your favourite IDE)
* Import maven project
* On maven / plugins options, execute  spring-boot/spring-boot:run

#### Running from maven command
> $ mvn spring-boot:run

### Running as packaged application 
> $ java -jar <yourOutputJar.jar> (You must previously have generated your jar).

## Viewing and testing api documentation
* http://localhosts:8090/swagger-ui.html (http://localhosts:8090/swagger-ui.html)
