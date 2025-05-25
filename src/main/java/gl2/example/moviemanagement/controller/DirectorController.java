package gl2.example.moviemanagement.controller;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.service.DirectorService;

@RestController
@RequestMapping("/api/directors/")

public class DirectorController {
  @Autowired
  private DirectorService directorService;

  @GetMapping("")
  public List<Director> getAllDirectors() {
    return directorService.getAllDirectors();
  }

  @GetMapping("/{id}")
  public Optional<Director> getDirectorById(@PathVariable Long id) {
    return directorService.getDirectorById(id);
  }

  @PostMapping
  public Director addDirector(@RequestBody Director director) {
    return directorService.addDirector(director);
  }

  @PutMapping("/{id}")
  public Director updateDirector(
      @PathVariable Long id,
      @RequestBody Director director) {
    return directorService.updateDirector(id, director);
  }

  @DeleteMapping("/{id}")
  public void deleteDirector(@PathVariable Long id) {
    directorService.deleteDirector(id);
  }

  @GetMapping("/getDirectorByMovieId/{movieId}")
  public Optional<Director> getDirectorByMovieId(@PathVariable Long movieId) {
    return directorService.getDirectorByMovieId(movieId);
  }

  @GetMapping("/getMoviesByDirectorId/{directorId}")
  public Optional<Set<Movie>> getMoviesByDirectorId(@PathVariable Long directorId) {
    return directorService.getMoviesByDirectorId(directorId);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Director>> searchDirectors(@RequestParam String name) {
    System.out.println("Searching for directors with title: " + name);
    List<Director> directors = directorService.searchDirectorsByNameContainingIgnoreCase(name);
    if (directors.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(directors);
  }
}
