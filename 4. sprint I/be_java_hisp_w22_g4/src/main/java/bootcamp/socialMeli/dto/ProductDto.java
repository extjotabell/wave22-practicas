package bootcamp.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}