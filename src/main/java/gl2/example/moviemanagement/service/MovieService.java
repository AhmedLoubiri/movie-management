package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Actor;
import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.model.Genre;
import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.repository.ActorRepository;
import gl2.example.moviemanagement.repository.DirectorRepository;
import gl2.example.moviemanagement.repository.GenreRepository;
import gl2.example.moviemanagement.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private DirectorRepository directorRepository;

  @Autowired
  private GenreRepository genreRepository;

  @Autowired
  private ActorRepository actorRepository;

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> getMovieById(Long id) {
    return movieRepository.findById(id);
  }

  // public Movie addMovie(Movie movie) {
  // return movieRepository.save(movie);
  // }

  public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
  }

  public Movie saveMovie(Movie movie) {
    Set<Genre> managedGenres = new HashSet<>();
    for (Genre genre : movie.getGenres()) {
      genreRepository.findById(genre.getId()).ifPresent(managedGenres::add);
    }
    movie.setGenres(managedGenres);

    Set<Actor> managedActors = new HashSet<>();
    for (Actor actor : movie.getActors()) {
      actorRepository.findById(actor.getId()).ifPresent(managedActors::add);
    }
    movie.setActors(managedActors);

    if (movie.getDirector() != null && movie.getDirector().getId() != null) {
      directorRepository.findById(movie.getDirector().getId())
          .ifPresent(movie::setDirector);
    }

    return movieRepository.save(movie);
  }

  public Movie addDirectorToMovie(Long movieId, Long directorId) {
    Movie movie = movieRepository.findById(movieId).get();
    Director director = directorRepository.findById(directorId).get();
    return movieRepository.save(movie);
  }
}
