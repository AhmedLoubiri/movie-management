// Fetch and display movies
async function fetchMovies() {
    const response = await fetch('/api/movies'); // Adjust endpoint as per your backend
    const movies = await response.json();
    const movieList = document.getElementById('movie-list');
    movieList.innerHTML = ''; // Clear existing list

    movies.forEach(movie => {
        const li = document.createElement('li');
        li.className = 'movie-item';
        li.innerHTML = `
            <h2>${movie.title}</h2>
            <img src="${movie.image_url}" alt="${movie.title}" style="max-width: 100px; display: block;">
            <p><strong>Year:</strong> ${movie.year}</p>
            <p><strong>Director ID:</strong> ${movie.director_id}</p>
            <p><strong>Genres:</strong> ${movie.genres.join(', ')}</p>
            <p><strong>Actors:</strong> ${movie.actors.join(', ')}</p>
            <button class="button" onclick="deleteMovie(${movie.id})">Delete</button>
        `;
        movieList.appendChild(li);
    });
}

// Add a new movie
async function addMovie(event) {
    event.preventDefault();
    const title = document.getElementById('movie-title').value;
    const image_url = document.getElementById('movie-image-url').value;
    const year = parseInt(document.getElementById('movie-year').value);
    const director_id = parseInt(document.getElementById('movie-director-id').value);
    const genres = document.getElementById('movie-genres').value.split(',').map(genre => genre.trim());
    const actors = document.getElementById('movie-actors').value.split(',').map(actor => actor.trim());

    await fetch('/api/movies', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, image_url, year, director_id, genres, actors })
    });

    document.getElementById('movie-form').reset();
    fetchMovies();
}

// Delete a movie
async function deleteMovie(id) {
    await fetch(`/api/movies/${id}`, { method: 'DELETE' });
    fetchMovies();
}

// Event listeners
document.getElementById('movie-form').addEventListener('submit', addMovie);

// Initial fetch
fetchMovies();