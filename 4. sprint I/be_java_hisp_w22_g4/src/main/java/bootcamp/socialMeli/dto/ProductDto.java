package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductDto {
    @Min(value = 1, message = "Se debe ingresar un id producto")
    private int product_id;
    @NotNull(message = "Se debe ingresar el nombre del producto")
    private String product_name;
    @NotNull(message = "Se debe ingresar el tipo")
    private String type;
    @NotNull(message = "Se dene ingresar la marca")
    private String brand;
    @NotNull(message = "Se debe el color")
    private String color;
    @NotNull(message = "Se debe ingresar nota")
    private String notes;
}
