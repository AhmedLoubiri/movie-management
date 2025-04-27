// Fetch and display movies
async function fetchMovies() {
  const response = await fetch("/api/movies");
  const movies = await response.json();
  const movieList = document.getElementById("movie-list");
  movieList.innerHTML = "";

  movies.forEach((movie) => {
    const li = document.createElement("li");
    li.className = "movie-item";
    // TODO fetch the director name from the API
    // TODO fetch the actor names from the API
    // TODO fetch the genre names from the API
    li.innerHTML = `
            <h2>${movie.title}</h2>
            <img src="${movie.image_url}" alt="${movie.title}"
                  style="max-width: 100px; display: block;">
            <p><strong>Year:</strong> ${movie.year}</p>
            <p><strong>Director ID:</strong> ${movie.director.name}</p>
            <p><strong>Genres:</strong> ${movie.genres.map((genre) => genre.name).join(", ")}</p>
            <p><strong>Actors:</strong> ${movie.actors.map((actor) => actor.name).join(", ")}</p>
            <button class="button"
              onclick="if(confirm('are you sure ??')){
                deleteMovie(${movie.id})
              }">Delete</button>
        `;
    movieList.appendChild(li);
  });
}

// Add a new movie
async function addMovie(event) {
  event.preventDefault();
  const title = document.getElementById("movie-title").value;
  const imageUrl = document.getElementById("movie-image-url").value;
  const year = parseInt(document.getElementById("movie-year").value);
  const director_id = parseInt(
    document.getElementById("movie-director-id").value,
  );
  const genres = document
    .getElementById("movie-genres")
    .value.split(",")
    .map((genre) => genre.trim());
  const actors = document
    .getElementById("movie-actors")
    .value.split(",")
    .map((actor) => actor.trim());

  console.log(
    JSON.stringify({
      genres: genres.map((id) => {
        ({ id });
      }),
    }),
  );

  console.log(
    JSON.stringify({
      title,
      imageUrl,
      year,
      director: { id: director_id },
      genres: genres.map((id) => {
        ({ id });
      }),
      actors: actors.map((id) => {
        ({ id });
      }),
    }),
  );

  /*
  await fetch("/api/movies", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      title,
      image_url: imageUrl,
      year,
      director_id,
      genres: document
        .getElementById("movie-genres")
        .value.split(",")
        .map((genre) => genre.trim()),
      actors,
    }),
  });

  document.getElementById("movie-form").reset();
  fetchMovies();
  */
}

// Delete a movie
async function deleteMovie(id) {
  await fetch(`/api/movies/${id}`, { method: "DELETE" });
  fetchMovies();
}

// Event listeners
document.getElementById("movie-form").addEventListener("submit", addMovie);

// Initial fetch
fetchMovies();

