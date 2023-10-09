package vehiculosHQL.vehiculosHQL.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Data
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;
    @Column(name = "perdida_economica")
    private double perdidaEconomica;
}
