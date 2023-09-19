package com.meli.be_java_hisp_w22_g01.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromo {
    private int discount;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
}
