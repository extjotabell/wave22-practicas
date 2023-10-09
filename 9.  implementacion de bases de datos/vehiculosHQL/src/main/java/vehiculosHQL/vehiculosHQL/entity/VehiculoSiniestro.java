package vehiculosHQL.vehiculosHQL.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestro {
    private int id;
    private Vehiculo vehiculo;
    private List<Siniestro> siniestros;

}
