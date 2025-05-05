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
| **GET**    | `/api/movies` |  |
| **GET**    | `/api/movies` |  |
| **GET**    | `/api/movies` |  |
| **POST**   | `/api/movies` |  |
| **DELETE** | `/api/movies` |  |
| **PUT**    | `/api/movies` |  |
