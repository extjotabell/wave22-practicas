package salvo.nicolas.jewelry.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String name;
    private String material;
    private double weight;
    private String peculiarity;
    private boolean hasStone;
    private boolean sellable;
}
