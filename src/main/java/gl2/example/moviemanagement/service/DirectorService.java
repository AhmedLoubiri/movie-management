package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository DirectorRepository;

    public List<Director> getAllDirectors() { return DirectorRepository.findAll(); }

    public Optional<Director> getGenreById(Long id){ return DirectorRepository.findById(id); }

    public Director addDirector(Director Director){ return DirectorRepository.save(Director); }

    public void deleteDirector(Long id){ DirectorRepository.deleteById(id); }
}
