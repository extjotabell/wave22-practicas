package salvo.nicolas.movieshql.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import salvo.nicolas.movieshql.model.Genre;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private GenreDTO genre;
}
