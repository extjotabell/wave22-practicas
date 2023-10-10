package practicaHQL.practicaHQL.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private String title;
    private double rating;
    private int awards;
    @JsonProperty("release_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;
    private int length;
}
