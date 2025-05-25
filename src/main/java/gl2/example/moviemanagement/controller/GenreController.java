package gl2.example.moviemanagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import gl2.example.moviemanagement.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gl2.example.moviemanagement.model.Genre;
import gl2.example.moviemanagement.service.GenreService;

@RestController
@RequestMapping("/api/genres/")

public class GenreController {
  @Autowired
  private GenreService genreService;

  @GetMapping("")
  public List<Genre> getAllGenres() {
    return genreService.getAllGenres();
  }

  @GetMapping("/{id}")
  public Optional<Genre> getGenreById(@PathVariable Long id) {
    return genreService.getGenreById(id);
  }

  @PostMapping
  public Genre addGenre(@RequestBody Genre genre) {
    return genreService.addGenre(genre);
  }

  @PutMapping("/{id}")
  public Genre updateGenre(
      @PathVariable Long id,
      @RequestBody Genre genre) {
    return genreService.updateGenre(id, genre);
  }

  @DeleteMapping("/{id}")
  public void deleteGenre(@PathVariable Long id) {
    genreService.deleteGenre(id);
  }

  @GetMapping("/getMoviesByGenreId/{genreId}")
  public Optional<Set<Movie>> getDirectorByMovieId(@PathVariable Long genreId) {
    return genreService.getMoviesByGenreId(genreId);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Genre>> searchGenres(@RequestParam String name) {
    System.out.println("Searching for genres with title: " + name);
    List<Genre> genres = genreService.searchGenresByNameContainingIgnoreCase(name);
    if (genres.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(genres);
  }
}
