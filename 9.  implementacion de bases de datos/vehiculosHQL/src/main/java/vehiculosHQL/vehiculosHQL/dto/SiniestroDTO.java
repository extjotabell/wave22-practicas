package vehiculosHQL.vehiculosHQL.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vehiculosHQL.vehiculosHQL.entity.Vehiculo;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {
    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;
    @JsonProperty("perdida_economica")
    private double perdidaEconomica;
}
