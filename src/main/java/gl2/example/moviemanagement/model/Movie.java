package gl2.example.moviemanagement.model;

import jakarta.persistence.*;
import java.util.*;
@Entity
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private Integer year;

  @Column(name = "image_url")
  private String imageUrl;
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(
          name = "movie_genre",
          joinColumns = @JoinColumn(name = "movie_id"),
          inverseJoinColumns = @JoinColumn(name = "genre_id")
  )
  private Set<Genre> genres;
  public Movie() {
  }

  public Movie(String title, Integer year, String imageUrl) {
    this.title = title;
    this.year = year;
    this.imageUrl = imageUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String name) {
    this.title = name;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  public Set<Genre> getGenres() {
    return genres;
  }
  public void setGenres(Set<Genre> genres) {
    this.genres = genres;
  }

}
