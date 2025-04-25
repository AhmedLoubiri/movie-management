package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() { return movieRepository.findAll(); }

    public Optional<Movie> getEmployeeById(Long id){ return movieRepository.findById(id); }

    public Movie addMovie(Movie movie){ return movieRepository.save(movie); }

    public void deleteMovie(Long id){ movieRepository.deleteById(id); }
}
