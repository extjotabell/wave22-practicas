package salvo.nicolas.movieshql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyToOne;

import java.util.Set;


// TODO: hacer projections para traer solo una parte de la consulta y no todo. O, usar Query
@Entity
@Table(name = "actors")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor {
    @Id
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id")
    )
    private Set<Movie> movies;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id", referencedColumnName = "id")
    )
    private Set<Episode> episodes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Actor)) return false;

        return id != null && id.equals(((Actor) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // for synchronizing
    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.getActors().add(this);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
        movie.getActors().remove(this);
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
        episode.getActors().add(this);
    }

    public void removeEpisode(Episode episode) {
        episodes.remove(episode);
        episode.getActors().remove(this);
    }
}
