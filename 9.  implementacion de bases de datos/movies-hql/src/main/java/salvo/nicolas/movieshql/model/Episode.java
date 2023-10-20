package salvo.nicolas.movieshql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "episodes")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Episode {
    @Id
    private Integer id;
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;
    @ManyToMany(mappedBy = "episodes")
    private List<Actor> actors;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Episode)) return false;

        return id != null && id.equals(((Episode) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
