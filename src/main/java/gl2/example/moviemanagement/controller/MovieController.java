package gl2.example.moviemanagement.controller;

import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() { return movieService.getAllMovies(); }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(
            @PathVariable Long id,
            @RequestBody Movie movie) {

        // Optionnel : vérifier si l'employé avec l'ID donné existe
        Optional<Movie> existingMovie = movieService.getMovieById(id);
        if (existingMovie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Mettre à jour l'employé avec les nouvelles informations
        movie.setId(id);  // S'assurer que l'ID de l'objet est le même que celui dans l'URL
        Movie updatedEmployee = movieService.addMovie(movie);

        return ResponseEntity.ok(updatedEmployee);
    }
}
