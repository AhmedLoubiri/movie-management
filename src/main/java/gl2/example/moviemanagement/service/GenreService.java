package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.model.Genre;
import gl2.example.moviemanagement.model.Movie;
import gl2.example.moviemanagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository GenreRepository;

    public List<Genre> getAllGenres() { return GenreRepository.findAll(); }

    public Optional<Genre> getGenreById(Long id){ return GenreRepository.findById(id); }

    public Genre addGenre(Genre Genre){ return GenreRepository.save(Genre); }

    public void deleteGenre(Long id){ GenreRepository.deleteById(id); }

    public Optional<Set<Movie>> getMoviesByGenreId(Long genreId) {
        return GenreRepository.findById(genreId)
                .map(Genre::getMovies);
    }
    public List<Genre> searchGenresByNameContainingIgnoreCase(String name) {
        return GenreRepository.findByNameContainingIgnoreCase(name);
    }
}
