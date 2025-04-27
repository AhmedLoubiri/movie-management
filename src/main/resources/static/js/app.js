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
            <p>${movie.description}</p>
            <button class="button" onclick="deleteMovie(${movie.id})">Delete</button>
        `;
        movieList.appendChild(li);
    });
}

// Add a new movie
async function addMovie(event) {
    event.preventDefault();
    const title = document.getElementById('movie-title').value;
    const description = document.getElementById('movie-description').value;

    await fetch('/api/movies', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, description })
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