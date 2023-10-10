package practicaHQL.practicaHQL.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import practicaHQL.practicaHQL.entity.Movie;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private double rating;
    private Movie movie;
}
