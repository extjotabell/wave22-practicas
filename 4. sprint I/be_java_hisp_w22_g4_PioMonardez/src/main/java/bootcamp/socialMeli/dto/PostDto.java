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

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements IPost {
    @Min(value = 1, message = "Se debe ingresar un id usuario")
    private int user_id;
    private int post_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    @NotNull(message = "Se debe igresar un producto")
    private ProductDto product;
    @Min(value = 1, message = "Se debe ingresar un Categoria")
    private int category;
    @DecimalMin(value = "1", message = "Se debe ingresar un precio")
    private double price;

    @Override
    public int get_user_id() {
        return user_id;
    }

    @Override
    public int get_post_id() {
        return post_id;
    }

    @Override
    public LocalDate get_date() {
        return date;
    }

    @Override
    public ProductDto get_product() {
        return product;
    }

    @Override
    public int get_category() {
        return category;
    }

    @Override
    public double get_price() {
        return price;
    }
    @Override
    public boolean get_has_promo() {
        return false;
    }

    @Override
    public double get_discount() {
        return 0;
    }
}
