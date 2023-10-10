package practicaHQL.practicaHQL.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    private String title;
    private int number;
    @JsonProperty("release_date")
    private LocalDate realeaseDate;
    private double rating;
}
