package practicaHQL.practicaHQL.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private double rating;

    @ManyToOne
    @JoinColumn(name ="favorite_movie_id")
    private Movie movie;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "actor")
    @JsonManagedReference
    private List<ActorMovie> actorMovies;

    @OneToMany(mappedBy = "actor")
    private List<ActorEpisode> actorEpisodes;
}
