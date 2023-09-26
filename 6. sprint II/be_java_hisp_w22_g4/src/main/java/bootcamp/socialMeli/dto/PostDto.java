package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {
    @JsonProperty("user_id")
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;
    @NotNull(message = "Se debe igresar un producto")
    private @Valid ProductDto product;
    @NotNull(message = "El campo no puede estar vacío.")
    @Min(value = 1, message = "Se debe ingresar un Categoria")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMin(value = "1.0", message = "Se debe ingresar un precio")
    @DecimalMax(value = "10000000.0", message = "El precio máximo por producto es de 10.000.000")
    private Double price;
}
