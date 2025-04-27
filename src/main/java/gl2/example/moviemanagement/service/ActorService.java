package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Actor;
import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ActorService {

  @Autowired
  private ActorRepository ActorRepository;

  @Autowired
  private ActorRepository actorRepository;

  public List<Actor> getAllActors() {
    return ActorRepository.findAll();
  }

  public Optional<Actor> getGenreById(Long id) {
    return ActorRepository.findById(id);
  }

  public Actor addActor(Actor Actor) {
    return ActorRepository.save(Actor);
  }

  public void deleteActor(Long id) {
    ActorRepository.deleteById(id);
  }

  public Optional<Set<Movie>> getMoviesByActorId(Long actorId) {
    return actorRepository.findById(actorId)
        .map(Actor::getMovies);
  }
}
