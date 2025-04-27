package gl2.example.moviemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.service.DirectorService;

@RestController
@RequestMapping({ "/api/directors", "/api/directors/" })

public class DirectorController {
  @Autowired
  private DirectorService directorService;

  @GetMapping({ "", "/" })
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

  @DeleteMapping("/{id}")
  public void deleteDirector(@PathVariable Long id) {
    directorService.deleteDirector(id);
  }

  @GetMapping("/getDirectorByMovieId/{movieId}")
  public Optional<Director> getDirectorByMovieId(@PathVariable Long movieId) {
    return directorService.getDirectorByMovieId(movieId);
  }

}
