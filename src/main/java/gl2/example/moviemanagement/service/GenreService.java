package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Genre;
import gl2.example.moviemanagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository GenreRepository;

    public List<Genre> getAllGenres() { return GenreRepository.findAll(); }

    public Optional<Genre> getEmployeeById(Long id){ return GenreRepository.findById(id); }

    public Genre addGenre(Genre Genre){ return GenreRepository.save(Genre); }

    public void deleteGenre(Long id){ GenreRepository.deleteById(id); }
}
