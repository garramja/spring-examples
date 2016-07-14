# spring-example-livereload
This example show how can configure spring-boot application to use livereload feature. When spring-boot start embedded server it can be started within livereload service. This service allow to don't need restart or reload browser. Is like Hot swap, HCR, or similiar systems.

## Project structure
#### /src/es/jagr/config
Configuration class that contains spring boot configuration. Contains @ComponentScan annotation to allow scan different packages to spring.
> @SpringBootApplication is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan

#### /src/es/jagr/controllers
On this package there is a main controller with only one method mapped to "/"
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

### pom.xml
It's mandatory include spring-dev-tools dependecy to use livereload feature.

```
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
 </dependency>
```

See that spring maven plugin it's configured with fork = true because app execution must be in a diferent jvm that maven.

```
 <plugin>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-maven-plugin</artifactId>
   <configuration>
      <fork>true</fork>
   </configuration>
 </plugin>
```

If you run application with command line you must type:
> $ mvn spring-boot:run -Dfork=true

If you run application with your IDE using "Run as" into @SpringBootApplication class annotated, fork it's not necessary.
Only one server can be starte with livereload service.

## Starting application
Default port is configured to 8090. You are able to change on  > spring-example-rest-service\src\main\resources\application.properties

#### Running from IDE (used intelliJ, but you can use your favourite IDE)
* Import maven project
* On maven / plugins options, execute  spring-boot/spring-boot:run

It's very important if you start spring boot application form maven command you need to fork jvm execution. See pom.xml section on this document.

#### Running from maven command
> $ mvn spring-boot:run -Dfork=true

### Running as packaged application 
> $ java -jar <yourOutputJar.jar> (You must previously have generated your jar).

### Requirements
* Chrome web-browser with livereload extension

## Testing livereload
Now that server is running you can test livereload.
* Init chrome web-browser
* Go to http://localhost:8080/recipes
* Enable livereload on web-browser. You can enable it clicking on icon on top-right at chrome.
* You can do changes on code. There are several code commented to help you.
** es.jagr.controllers.RecipeController (line 35). See how list of recipes change his order.
** es.jagr.dao.RecipeDaoMap (line 30-31). See how new recipe is added to recipes.
** es.jagr.model.Recipe (line 13 & 82-99). Se how new field added to class.

![alt text](http://files.softicons.com/download/toolbar-icons/iconza-grey-icons-by-turbomilk/png/32x32/warning.png "")Warning
* If you are using eclipse saving files fires livereload.
* If you are using intelliJ, you must make project (ctrl+f9), because intelliJ don't recompile at autosave mode.
