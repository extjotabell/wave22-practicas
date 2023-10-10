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
@NoArgsConstructor
@AllArgsConstructor
public class SerieDto {
    private String title;
    @JsonProperty("releaase_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;
    @JsonProperty("end_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
}
