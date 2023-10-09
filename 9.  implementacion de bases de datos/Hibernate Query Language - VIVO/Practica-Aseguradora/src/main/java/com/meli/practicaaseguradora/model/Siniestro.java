package com.meli.practicaaseguradora.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Siniestro {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name ="id_siniestro")
    private Long id;

    private LocalDate Fecha;
    @Column(name ="perdida_economica")
    private double perdidaEconomica;
    @Column(name = "id_vehiculo_denunciado")
    private Long IdVehiculoDenunciado;
}
