---
id: moviesCR
aliases:
  - moviesCR
tags: []
---

<h1 align="center" style="color: red"> Compte Rendu: Movies management system </h1>

<h3 align=center>Réalisé par Ahmed Loubiri GL 2/2 et Louay Dardouri GL 2/3</h2>


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
| **GET**    | `/api/directors` | Get a json list of all directors |
| **GET**    | `/api/directors/{id}` | Get json for a director by id |
| **GET**    | `/api/movies/search?name=name` | Search directors by name |
| **GET**    | `/api/directors/getMoviesByDirectorId/{directorId}` | Returns a list of movies for director with directorId |
| **POST**   | `/api/directors` | Inserts a director |
| **DELETE** | `/api/directors/{id}` | Deletes a director by id |
| **PUT**    | `/api/directors/{id}` | Update a director by id |
