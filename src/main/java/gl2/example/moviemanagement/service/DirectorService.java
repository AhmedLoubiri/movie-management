package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.repository.DirectorRepository;
import gl2.example.moviemanagement.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DirectorService {

  @Autowired
  private DirectorRepository DirectorRepository;

  @Autowired
  private MovieRepository movieRepository;

  public List<Director> getAllDirectors() {
    return DirectorRepository.findAll();
  }

  public Optional<Director> getDirectorById(Long id) {
    return DirectorRepository.findById(id);
  }

  public Director addDirector(Director Director) {
    return DirectorRepository.save(Director);
  }

  public void deleteDirector(Long id) {
    DirectorRepository.deleteById(id);
  }

  public Optional<Director> getDirectorByMovieId(Long movieId) {
    return movieRepository.findById(movieId)
        .map(Movie::getDirector);
  }

  public Optional<Set<Movie>> getMoviesByDirectorId(Long directorId) {
    return DirectorRepository.findById(directorId)
        .map(Director::getMovies);
  }

  public List<Director> searchDirectorsByNameContainingIgnoreCase(String name) {
    return DirectorRepository.findByNameContainingIgnoreCase(name);
  }
}
