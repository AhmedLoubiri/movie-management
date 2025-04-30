package gl2.example.moviemanagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import gl2.example.moviemanagement.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @DeleteMapping("/{id}")
  public void deleteGenre(@PathVariable Long id) {
    genreService.deleteGenre(id);
  }

  @GetMapping("/getMoviesByGenreId/{genreId}")
  public Optional<Set<Movie>> getDirectorByMovieId(@PathVariable Long genreId) {
    return genreService.getMoviesByGenreId(genreId);
  }
}
