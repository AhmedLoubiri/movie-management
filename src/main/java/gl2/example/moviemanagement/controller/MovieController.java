package gl2.example.moviemanagement.controller;

import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
  @Autowired
  private MovieService movieService;

  @GetMapping
  public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
  }

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
  public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
    movieService.saveMovie(movie);
    return new ResponseEntity<>(HttpStatus.CREATED);
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

    Optional<Movie> existingMovie = movieService.getMovieById(id);
    if (existingMovie.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    movie.setId(id);
    Movie updatedEmployee = movieService.saveMovie(movie);

    return ResponseEntity.ok(updatedEmployee);
  }
}
