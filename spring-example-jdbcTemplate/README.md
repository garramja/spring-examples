# spring-example-jdbcTemplate
This example show how JdbTemplate help us to access database throw JDBC. This example use Java SQL database H2 Embedded  in memory.

* DELETE /recipes/{id} - Deletes recipe with specific {id}

## Project structure
The project structur is the same like spring-example-rest-service with some changes.

### Database configuration and JDBC support
We have added to pom.xml

>	<dependency>
>            <groupId>org.springframework</groupId>
>            <artifactId>spring-jdbc</artifactId>
>        </dependency>
>        <dependency>
>            <groupId>com.h2database</groupId>
>            <artifactId>h2</artifactId>
>        </dependency>
>    </dependencies>


### Database initializtion.
When springboot starts, it scans resource package to find db files resources.
* schema.sql: with this file into resources, sprinboot is able to scan this resource and recreate schema.
* data.sql: like schema file, springboot get this file to insert values on schema.

### RecipeDaoDb
In this example, RecipeDaoDb is added to Dao package. This Class is configured as repository and this is the class that will use JdbcTemplate. Every method on this DAO, use different methods of JdbcTemplate to access database.

### Profiles
See that RecipeDaoDb and RecipeDaoMap have @Profile annotation with diferent values. This example use profiles for use RecipeDaoDb or RecipeDaoMap depending on spring.profiles.active value on application.properties.

## Starting application
Default port is configured to 8090. You are able to change on  > spring-example-rest-service\src\main\resources\application.properties

#### Running from IDE (used intelliJ, but you can use your favourite IDE)
* Import maven project
* On maven / plugins options, execute  spring-boot/spring-boot:run

#### Running from maven command
> $ mvn spring-boot:run

### Running as packaged application 
> $ java -jar <yourOutputJar.jar> (You must previously have generated your jar).

## Testing profile and JdbcTemplate

* Configure spring.profiles.active=dev
* http://localhost:8090/recipes -> See that recipe with id=pae has Paella as name
* Stop server
* Configure spring.profiles.active=stg
* http://localhost:8090/recipes -> See that recipe with id=pae has Paella ciega as name. This is because on data.sql "pae" is inserted as Paella ciega.
* You can invoke all rest methods and services will use data on memory map or data on memory db depending your profile configuration.
