package gl2.example.moviemanagement.repository;

import gl2.example.moviemanagement.model.Director;
import gl2.example.moviemanagement.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByNameContainingIgnoreCase(String name);
}
