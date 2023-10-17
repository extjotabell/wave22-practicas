package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="test_case")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case", nullable = false)
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
