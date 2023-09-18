package bootcamp.socialMeli.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private Double price;
}
