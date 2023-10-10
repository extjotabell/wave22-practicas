package practicaHQL.practicaHQL.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private int number;
    @Column(name = "release_date")
    private LocalDate realeaseDate;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "episode")
    List<ActorEpisode> actorEpisodes;

}
