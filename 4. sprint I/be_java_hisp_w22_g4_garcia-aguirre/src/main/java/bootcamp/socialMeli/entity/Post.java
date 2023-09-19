package bootcamp.socialMeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int post_id;
    private int user_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    private int product_id;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

    public Post(int post_id, int user_id, LocalDate date, int product_id, int category, double price) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.date = date;
        this.product_id = product_id;
        this.category = category;
        this.price = price;
    }
}
