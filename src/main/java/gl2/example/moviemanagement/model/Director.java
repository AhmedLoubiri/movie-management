package gl2.example.moviemanagement.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

@Entity
public class Director {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Integer age;

  @Column(name = "image_url")
  private String imageUrl;

  @OneToMany(mappedBy = "director")
  @JsonIgnore
  private Set<Movie> movies;

  public Director() {
  }

  public Director(String name, Integer age, String imageUrl) {
    this.name = name;
    this.age = age;
    this.imageUrl = imageUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Set<Movie> getMovies() {
    return movies;
  }

  public void setMovies(Set<Movie> movies) {
    this.movies = movies;
  }
}
