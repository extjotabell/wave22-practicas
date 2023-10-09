package vehiculosHQL.vehiculosHQL.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vehiculosHQL.vehiculosHQL.entity.Siniestro;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDto {
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("año_fabricacion")
    private int añoFabricacion;
    @JsonProperty("cantidad_ruedas")
    private int cantidadRuedas;
    private List<SiniestroDTO> siniestros;

}
