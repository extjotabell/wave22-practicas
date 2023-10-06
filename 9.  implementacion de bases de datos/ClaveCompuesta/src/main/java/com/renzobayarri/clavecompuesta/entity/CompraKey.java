package com.renzobayarri.clavecompuesta.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@EqualsAndHashCode
public class CompraKey implements Serializable {

    private Long clienteId;

    private LocalDate fecha;

}
