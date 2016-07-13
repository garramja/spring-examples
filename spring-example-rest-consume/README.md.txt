# spring-example-rest-consume
This example show how spring an RestTemplate class help us to consume rest api. This example consume rest api build in spring-example-rest-service example.

## Project structure
#### /src/es/jagr/config
Configuration class that contains spring boot configuration. Contains @ComponentScan annotation to allow scan different packages to spring.
> @SpringBootApplication is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan
This class implements CommandLineRunner that allow execute method run at start app. So, all into run method is executed when start with spring-boot:run.

#### /src/es/jagr/model
Class with the model data used on application. In this example use recipes because we want work with recpies api build in spring-example-rest-service example.
> @JsonIgnoreProperties -> Indicate that any properties not bound in this type should be ignored.

## Starting application
Default port is configured to 8091. You are able to change on  > spring-example-rest-consume\src\main\resources\application.properties

#### Running from IDE (used intelliJ, but you can use your favourite IDE)
* Import maven project
* On maven / plugins options, execute  spring-boot/spring-boot:run

#### Running from maven command
> $ mvn spring-boot:run

### Running as packaged application
> $ java -jar <yourOutputJar.jar> (You must previously have generated your jar).

## Result (Logger output)
#### Insert new Hot dog Recipe
#### Getting Hot dog recipe
#### Recipe{id='hdo', name='Hot dog', stars=5}
#### Update Hot dog recipe to add ketchup
#### Getting all recipes
#### Recipe{id='hdo', name='Hot dog with ketchup', stars=5}
#### Recipe{id='pae', name='Paella', stars=5}
#### Recipe{id='spo', name='Spanish omelete', stars=4}
#### Recipe{id='coc', name='Cocido Madrileño', stars=3}
#### Delete Hot dog recipe
#### Getting all recipes
#### Recipe{id='pae', name='Paella', stars=5}
#### Recipe{id='spo', name='Spanish omelete', stars=4}
#### Recipe{id='coc', name='Cocido Madrileño', stars=3}