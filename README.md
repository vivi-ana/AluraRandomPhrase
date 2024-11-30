# Random Phrase Application

This RESTful API allows users to retrieve random phrases from movies and TV series.

#### **Technologies Used**

Java 17

Spring Data JPA with JPQL

Database: PostgreSQL

## Setup

Create a `.env` file in the root directory of the application and add the following database connection configuration:

```properties
DB_HOST=
DB_NAME=
DB_USERNAME=
DB_PASSWORD=
```

**Ensure that the database connection details in the .env file are correctly filled in before running the application.**

* DB_HOST: It is the host or the IP address of the database server that the application will connect to in order to access the data. Typically, this could be something like localhost if the database is on the same machine as the application, or the IP address of the database server if it is on a remote server.
* DB_NAME: This value corresponds to the specific name of the database that contains the tables and data that the application needs to function correctly.
* DB_USERNAME: It is the username that the application will use to connect to the database.
* DB_PASSWORD: It is the password associated with the username specified above.

**You also need the [frontend side](https://github.com/vivi-ana/FrontEndAluraRandomPhrase)**

## CORS Configuration Setup

### Note
Please make sure to check the [frontend side](https://github.com/vivi-ana/FrontEndAluraRandomPhrase) before configuring CORS.
## Online CORS Configuration

If your content is being consumed online, configure [the CORS settings](https://github.com/vivi-ana/AluraRandomPhrase/blob/main/src/main/java/com/aluracursos/screenmatch_phrase/configuration/CorsConfiguration.java) in your Spring Boot application:

```java
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://vivi-ana.github.io")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
```

If you choose [online deployment](https://vivi-ana.github.io/FrontEndAluraRandomPhrase/) on the frontend side, make sure that the allowedOrigins value is set to "https://vivi-ana.github.io" to permit requests from that specific online origin.

## Localhost CORS Configuration

For local development where content is consumed locally, adjust [the CORS settings](https://github.com/vivi-ana/AluraRandomPhrase/blob/main/src/main/java/com/aluracursos/screenmatch_phrase/configuration/CorsConfiguration.java) in your Spring Boot application:

```java
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5550")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
```
You can modify the allowedOrigins value to suit your local setup, such as "http://127.0.0.1:5550", adjusting the HTTP address and port as necessary.

# Accessing the Endpoint

To access the endpoint for retrieving a random phrase, follow these steps:

1. Make a GET request to the following endpoint:
```http
GET /series/phrase
```
2. Upon a successful request, the endpoint will return a `PhraseDTO` object with the following structure:
- `title`:  The title of the movie or series from which the phrase originates.
- `phrase`: The random phrase from a series or movie.
- `character`: The character related to the phrase.
- `poster`: The poster associated with the phrase.

### Example Request:
**Before accessing the endpoint for retrieving a random phrase, ensure you have a database set up with the necessary data.**

```http
GET /series/phrase
```

```json
{
  "title": "Title of the Movie or Series",
  "phrase": "Sample random phrase from a series",
  "character": "Character Name",
  "poster": "URL to the Poster Image"
}
```

**Before accessing the endpoint for retrieving a random phrase, ensure you have a database set up with the necessary data. You can try with this:**

```sql
insert into phrase(id, phrase, character, title, poster) values (1, 'Friends dont lie', 'Eleven', 'Stranger Things', 'https://m.media-amazon.com/images/M/MV5BMDZkYmVhNjMtNWU4MC00MDQxLWE3MjYtZGMzZWI1ZjhlOWJmXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg');
insert into phrase(id, phrase, character, title, poster) values (2, 'I am not in danger, Skyler. I am the danger', 'Walter White', 'Breaking Bad', 'https://m.media-amazon.com/images/M/MV5BYTU3NWI5OGMtZmZhNy00MjVmLTk1YzAtZjA3ZDA3NzcyNDUxXkEyXkFqcGdeQXVyODY5Njk4Njc@._V1_SX300.jpg');
insert into phrase(id, phrase, character, title, poster) values (3, 'It aint about how hard you hit. Its about how hard you can get hit and keep moving forward. How much you can take and keep moving forward. Thats how winning is done', 'Rocky Balboa', 'Rocky', 'https://m.media-amazon.com/images/M/MV5BNWIyNmQyNjctYmVmMS00MGI4LWIxMmUtNjA0ODYzOTA0Yjk0L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg');
insert into phrase(id, phrase, character, title, poster) values (4, 'May the Force be with you', 'Obi-Wan Kenobi', 'Star Wars', 'https://m.media-amazon.com/images/M/MV5BOTA5NjhiOTAtZWM0ZC00MWNhLThiMzEtZDFkOTk2OTU1ZDJkXkEyXkFqcGdeQXVyMTA4NDI1NTQx._V1_SX300.jpg');
insert into phrase(id, phrase, character, title, poster) values (5, 'You jump, I jump, remember?', 'Rose Dawson', 'Titanic', 'https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg');
```