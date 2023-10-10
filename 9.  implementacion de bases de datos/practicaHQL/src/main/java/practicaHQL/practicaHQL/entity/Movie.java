package practicaHQL.practicaHQL.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String title;
    private double rating;
    private int awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    @JsonManagedReference
    private List<ActorMovie> actorMovies;

}
