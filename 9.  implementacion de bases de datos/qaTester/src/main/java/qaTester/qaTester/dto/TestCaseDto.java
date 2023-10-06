package qaTester.qaTester.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseDto {
    private String description;
    private boolean tested;
    private boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
