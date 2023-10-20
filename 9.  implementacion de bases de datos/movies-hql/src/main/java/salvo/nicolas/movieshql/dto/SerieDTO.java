package salvo.nicolas.movieshql.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private GenreDTO genre;
}
