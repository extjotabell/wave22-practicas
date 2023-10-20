package salvo.nicolas.movieshql.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
}
