package gl2.example.moviemanagement.service;

import gl2.example.moviemanagement.model.Actor;
import gl2.example.moviemanagement.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository ActorRepository;

    public List<Actor> getAllActors() { return ActorRepository.findAll(); }

    public Optional<Actor> getEmployeeById(Long id){ return ActorRepository.findById(id); }

    public Actor addActor(Actor Actor){ return ActorRepository.save(Actor); }

    public void deleteActor(Long id){ ActorRepository.deleteById(id); }
}
