package com.example.compras.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

}
