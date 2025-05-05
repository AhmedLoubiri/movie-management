package gl2.example.moviemanagement.repository;

import gl2.example.moviemanagement.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByNameContainingIgnoreCase(String name);
}
