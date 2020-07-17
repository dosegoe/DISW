# rest_api
Esta es la rest api que use en la ayudantía


Los requisitos son:

- JDK 1.8
- Maven 
- PostgreSQL

Se corre con:

```
mvn spring-boot:run
```
en consola


Recuerden cambiar el  application.properties con los datos de su BD

```
#data conection
spring.datasource.url=jdbc:postgresql://localhost:5432/asdf
spring.datasource.username=postgres
spring.datasource.password=1234
```
