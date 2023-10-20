package salvo.nicolas.movieshql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "seasons")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Season {
    @Id
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate release_date;
    private LocalDate end_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id")
    private Serie serie;
    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Season)) return false;

        return id != null && id.equals(((Season) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
