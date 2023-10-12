package com.clothes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private LocalDate saleDate;
    private Double total;
    private Integer paymentType;
    @ManyToMany
    @JoinTable(
            name = "sales_clothes",
            joinColumns = @JoinColumn(name = "sale_number"),
            inverseJoinColumns = @JoinColumn(name = "clothes_code")
    )
    private List<Clothes> clothesList;
}
