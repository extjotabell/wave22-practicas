package salvo.nicolas.movieshql.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate release_date;
    private LocalDate end_date;
    private SerieDTO serie;
//    private List<EpisodeDTO> episodes;
}
