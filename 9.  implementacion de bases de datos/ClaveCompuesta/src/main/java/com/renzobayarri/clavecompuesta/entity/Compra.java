package com.renzobayarri.clavecompuesta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "compras")
@Getter
@Setter
@IdClass(value = CompraKey.class)
public class Compra implements Serializable {

    @Id
    private Long clienteId;

    @Id
    private LocalDate fecha;

}
