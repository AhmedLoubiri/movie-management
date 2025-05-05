package gl2.example.moviemanagement.repository;

import gl2.example.moviemanagement.model.Actor;
import gl2.example.moviemanagement.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByNameContainingIgnoreCase(String name);
}
