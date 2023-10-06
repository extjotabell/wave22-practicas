package joyeriaCRUD.joyeriaCRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String material;
    private int peso;
    private String particularidades;
    private boolean poseePiedra;
    private boolean ventaONo;

    public Joya(String nombre, String material, int peso, String particularidades, boolean poseePiedra, boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidades = particularidades;
        this.poseePiedra = poseePiedra;
        this.ventaONo = ventaONo;
    }

    public Joya() {

    }
}
