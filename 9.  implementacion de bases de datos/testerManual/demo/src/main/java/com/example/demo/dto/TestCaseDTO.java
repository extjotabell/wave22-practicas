package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@Setter
public class TestCaseDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate lastUpdate;
}
