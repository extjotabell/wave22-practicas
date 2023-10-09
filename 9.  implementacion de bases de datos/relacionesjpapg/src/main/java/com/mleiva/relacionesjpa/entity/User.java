package com.mleiva.relacionesjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // Relacion uno a uno con Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id") // JoinColumn se usa para definir el nombre de la columna en la tabla Users que mapea a la clave primaria de la tabla Address
    private Address address; //Name indica el nombre que va tener la columna en nuestra tabla de la BD, referencedColumnName indica el nombre del Atributo de la otra tabla que queremos relacionar
}
