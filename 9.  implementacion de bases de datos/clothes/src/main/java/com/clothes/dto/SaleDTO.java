package com.clothes.dto;

import com.clothes.model.Clothes;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long number;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate saleDate;
    private Double total;
    private Integer paymentType;
    private List<Clothes> clothesList;
}
