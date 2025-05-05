package gl2.example.moviemanagement.repository;

import gl2.example.moviemanagement.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  List<Movie> findByTitleContainingIgnoreCase(String title);

  List<Movie> findByTitle(String title);
}
