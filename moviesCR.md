---
id: moviesCR
aliases:
  - moviesCR
tags: []
---

<h1 align="center" style="color: red"> Compte Rendu: Movies management system </h1>

<h3 align=center>Work by Ahmed Loubiri GL 2/2 et Louay Dardouri GL 2/3</h2>


## Database (MySQL)

![apprepschema.png](assets/imgs/apprepschema.png)

| Relation | Type | Description |
| ------------- | -------------- | -------------- |
| `director_id` | ManyToOne | Each movie has only one director and each director has many movies. |
| `movie_actor` | ManyToMany | Each movie has many actors and vice versa. |
| `movie_genre` | ManyToMany | Each movie has many genres and vice versa. |


## Endpoints

#### Movies
| Method | URI | Description |
| ---- | ------------- | -------------- |
| **GET**    | `/api/movies` | Get a json list of all movies |
| **GET**    | `/api/movies/{id}` | Get json for a movie by id |
| **GET**    | `/api/movies/search?title=title` | Search movies by title |
| **POST**   | `/api/movies` | Inserts a movie |
| **DELETE** | `/api/movies/{id}` | Deletes a movie by id |
| **PUT**    | `/api/movies/{id}` | Update a movie by id |

#### Director
| Method | URI | Description |
| ---- | ------------- | -------------- |
| **GET**    | `/api/directors/` | Get a json list of all directors |
| **GET**    | `/api/directors/{id}` | Get json for a director by id |
| **GET**    | `/api/movies/search?name=name` | Search directors by name |
| **GET**    | `/api/directors/getMoviesByDirectorId/{directorId}` | Returns a list of movies for director with directorId |
| **POST**   | `/api/directors/` | Inserts a director |
| **DELETE** | `/api/directors/{id}` | Deletes a director by id |
| **PUT**    | `/api/directors/{id}` | Update a director by id |

#### Actor
| Method | URI | Description |
| ---- | ------------- | -------------- |
| **GET**    | `/api/actors/` | Get a json list of all actors |
| **GET**    | `/api/actors/{id}` | Get json for an actor by id |
| **GET**    | `/api/movies/search?name=name` | Search actors by name |
| **GET**    | `/api/actors/getMoviesByactorId/{actorId}` | Returns a list of movies for actor with actorId |
| **POST**   | `/api/actors/` | Inserts an actor |
| **DELETE** | `/api/actors/{id}` | Deletes an actor by id |
| **PUT**    | `/api/actors/{id}` | Update an actor by id |

#### Genre
| Method | URI | Description |
| ---- | ------------- | -------------- |
| **GET**    | `/api/genres/` | Get a json list of all genres |
| **GET**    | `/api/genres/{id}` | Get json for a genre by id |
| **GET**    | `/api/movies/search?name=name` | Search genres by name |
| **GET**    | `/api/genres/getMoviesBygenreId/{genreId}` | Returns a list of movies for genre with genreId |
| **POST**   | `/api/genres/` | Inserts a genre |
| **DELETE** | `/api/genres/{id}` | Deletes a genre by id |
| **PUT**    | `/api/genres/{id}` | Update a genre by id |


## Testing

We have included **`Swagger UI`** to facilitate API testing and to provide clear, interactive documentation for better understanding and validation of the endpoints

It is integrated by adding the `springdoc-openapi-ui` dependency in the project's build configuration and accessing the documentation at `/swagger-ui/index.html`

*pom.xml*
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.2.0</version>
</dependency>
```

For further simplification, we added a redirect to the Swagger UI, allowing users to access it directly from `/api/test`
To do so we added a home controller.

*HomeController.java*
```java
package gl2.example.moviemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({ "/", "/api/test", "/api/test/" })
  public String index() {
    return "redirect:/swagger-ui/index.html";
  }
}
```
