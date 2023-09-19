package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDto implements IPostDto {
    @Min(value = 1, message = "Se debe ingresar un id usuario")
    private int user_id;
    private int post_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    @NotNull(message = "Se debe igresar un Producto")
    private ProductDto product;
    @Min(value = 1, message = "Se debe ingresar un categoría")
    private int category;
    @DecimalMin(value = "1", message = "Se debe ingresar un precio")
    private double price;
    private boolean has_promo;
    private double discount;

    @Override
    public boolean has_promo() {
        return has_promo;
    }

    @Override
    public double discount() {
        return discount;
    }
}
