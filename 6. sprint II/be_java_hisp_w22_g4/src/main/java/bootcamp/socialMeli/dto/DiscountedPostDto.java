package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountedPostDto {
    @JsonProperty("user_id")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    @NotNull(message = "El  id no puede estar vacío.")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotEmpty(message = "La fecha no puede estar vacía.")
    private LocalDate date;
    @NotNull(message = "Se debe ingresar un producto")
    private @Valid ProductDto product;
    @Min(value = 1, message = "Se debe ingresar un Categoria")
    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;
    @DecimalMin(value = "1", message = "Se debe ingresar un precio")
    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;
}
