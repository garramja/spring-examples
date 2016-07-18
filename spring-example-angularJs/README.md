# spring-example-angularJs
This example show how consume restful api created on example "spring-example-rest-service" with angularJS. It's very simple example of CRUD operations. 

## Project structure
#### /public/index.html
Contains html structure with angular tags to manage data from api rest.

#### /src/es/jagr/Application.java
Configuration class that contains spring boot configuration. Contains @ComponentScan annotation to allow scan different packages to spring.
> @SpringBootApplication is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan

## Enable CORS to api Rest
You must add CORS support at the rest api developed on "spring-example-rest-service". You must add it because this example emulate request from another server.

To enable CORS support on "spring-example-rest-service":
* Add at Application.java
´´´
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("POST","DELETE","GET","PUT");
            }
        };
    }
´´´
This code allow this request method's. If is not specified on allowedMethods, onlye POST, HEAD and GET is supported.
* Restart server

## Starting application
Default port is configured to 9000. You are able to change on  > spring-example-angularJs\src\main\resources\application.properties

#### Running from IDE (used intelliJ, but you can use your favourite IDE)
* Import maven project
* On maven / plugins options, execute  spring-boot/spring-boot:run

#### Running from maven command
> $ mvn spring-boot:run

### Running as packaged application
> $ java -jar <yourOutputJar.jar> (You must previously have generated your jar).

## Access
Access to http://localhost:9000
