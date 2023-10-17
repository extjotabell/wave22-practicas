package com.meli.obtenerdiploma.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ErrorDTOTest {

    private ErrorDTO errorDTO;

    @BeforeEach
    void setup() {
        errorDTO = new ErrorDTO();
    }

    @Test
    @DisplayName("Test ErrorDTO - Getters and Setters")
    void testErrorDTOGettersAndSetters() {
        // Set values using setters
        errorDTO.setName("Sample Error");
        errorDTO.setDescription("This is a sample error description");

        // Use getters to retrieve values
        assertEquals("Sample Error", errorDTO.getName());
        assertEquals("This is a sample error description", errorDTO.getDescription());
    }

    @Test
    @DisplayName("Test ErrorDTO - All-Arg Constructor")
    void testErrorDTOAllArgConstructor() {
        // Create an ErrorDTO using the all-arg constructor
        ErrorDTO errorDTO = new ErrorDTO("Sample Error", "This is a sample error description");

        // Use getters to retrieve values
        assertEquals("Sample Error", errorDTO.getName());
        assertEquals("This is a sample error description", errorDTO.getDescription());
    }

    @Test
    @DisplayName("Test ErrorDTO - No-Arg Constructor")
    void testErrorDTONoArgConstructor() {
        // Use the no-arg constructor to create an ErrorDTO
        ErrorDTO errorDTO = new ErrorDTO();

        // Set values using setters
        errorDTO.setName("Another Error");
        errorDTO.setDescription("This is another error description");

        // Use getters to retrieve values
        assertEquals("Another Error", errorDTO.getName());
        assertEquals("This is another error description", errorDTO.getDescription());
    }
}
