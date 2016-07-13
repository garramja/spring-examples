# spring-example-rest-service
This example show how spring help us to build a simple rest application with most used methods.
This methods are:
* GET /recipes - Retrieves all recipes
* GET /recipes/{id} - Retrieves a specific recipe
* POST /recipes - Insert a new recipe
* PUT /recipes/{id} - Updates recipe with specific {id}
* DELETE /recipes/{id} - Deletes recipe with specific {id}

## Project structure
#### /src/es/jagr/config
Configuration class that contains spring boot configuration. Contains @ComponentScan annotation to allow scan different packages to spring.

#### /src/es/jagr/controllers
On this package there is a main controller with methods published on rest api.
> @RestController -> Spring 4 annotation that is equivalent to @Controller and @ResponseBody
> @RequestMapping -> Spring MVC annotation that map request url
> @Autowired -> Spring annotation to inject Service

#### /src/es/jagr/dao
This package contains DAO Interface and his implementation that emulate data access. In this example the data is in memory. Due to, every server restart, reset all data.

#### /src/es/jagr/model
Class with the model data used on application. In this example Recipes (ñam, ñam).

#### /src/es/jagr/service
Service layer
> Controller <--> Service <--> DAO
> @Service Spring annotation that indicates that annotated class is a service.

## Starting application
Default port is configured to 8090. You are able to change on  > spring-example-rest-service\src\main\resources\application.properties

#### Running from IDE (used intelliJ, but you can use your favourite IDE)
* Import maven project
* On maven / plugins options, execute  spring-boot/spring-boot:run

#### Running from maven command
> $ mvn spring-boot:run

### Running as packaged application 
> $ java -jar <yourOutputJar.jar> (You must previously have generated your jar).

## Executing methods
Now that server is running you can invoke methods like.

* http://localhost:8090/recipes (with GET Http method)
* http://localhost:8090/recipes/pae (with GET Http method)
* http://localhost:8090/recipes (with POST Http method and json like {"id":"fpo","name":"fried potatos","stars":3})
* http://localhost:8090/recipes (with PUT Http method and json like {"id":"fpo","name":"fried potatos with salt","stars":4}))
* http://localhost:8090/recipes/fpo (with DEL Http method)