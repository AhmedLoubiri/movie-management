package gl2.example.moviemanagement.controller;

import gl2.example.moviemanagement.model.Actor;
import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.service.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/actors/")
public class ActorController {
  @Autowired
  private ActorService actorService;

  @GetMapping("")
  public List<Actor> getAllActors() {
    return actorService.getAllActors();
  }

  @GetMapping("/{id}")
  public Optional<Actor> getActorById(@PathVariable Long id) {
    return actorService.getGenreById(id);
  }

  @PostMapping
  public Actor addActor(@RequestBody Actor actor) {
    return actorService.addActor(actor);
  }

  @DeleteMapping("/{id}")
  public void deleteActor(@PathVariable Long id) {
    actorService.deleteActor(id);
  }

  @GetMapping("/getMoviesByActorId/{actorId}")
  public Optional<Set<Movie>> getMoviesByActorId(@PathVariable Long actorId) {
    return actorService.getMoviesByActorId(actorId);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Actor>> searchActors(@RequestParam String name) {
    System.out.println("Searching for actors with name: " + name);
    List<Actor> actors = actorService.searchActorsByNameContainingIgnoreCase(name);
    if (actors.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(actors);
  }
}
