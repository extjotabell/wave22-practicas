package vehiculosHQL.vehiculosHQL.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter @Setter
@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private int cantidadRuedas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Set<Siniestro> siniestros;

}
