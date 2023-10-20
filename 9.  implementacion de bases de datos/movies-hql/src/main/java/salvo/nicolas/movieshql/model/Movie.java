package salvo.nicolas.movieshql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {
    @Id
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Movie)) return false;

        return id != null && id.equals(((Movie) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
