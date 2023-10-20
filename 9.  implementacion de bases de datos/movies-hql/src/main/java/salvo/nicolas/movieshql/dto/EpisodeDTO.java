package salvo.nicolas.movieshql.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import salvo.nicolas.movieshql.model.Actor;
import salvo.nicolas.movieshql.model.Season;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
//    private List<ActorDTO> actors;
    private SeasonDTO season;
}
