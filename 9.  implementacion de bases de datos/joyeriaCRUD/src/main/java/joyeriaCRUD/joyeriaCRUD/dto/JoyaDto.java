package joyeriaCRUD.joyeriaCRUD.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoyaDto {
    private String nombre;
    private String material;
    private int peso;
    private String particularidades;
    @JsonProperty("posee_priedra")
    private boolean poseePiedra;
    private boolean ventaONo;
}
