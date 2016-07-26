package es.jagr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.fasterxml.classmate.TypeResolver;

/**
 * Main class configuration for Spring boot
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan("es.jagr.*")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket recipeApi() {
		ApiInfo apiInfo = new ApiInfo("API recipe example","1.0.0","1.0.0","Licencia","Javier García <javier.garcia@sm2baleares.es>","API recipe","");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
                .groupName("API recipe")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
				.tags(new Tag("Recipe service", "All services for recipe API"))
				.enableUrlTemplating(true);
	}

}
