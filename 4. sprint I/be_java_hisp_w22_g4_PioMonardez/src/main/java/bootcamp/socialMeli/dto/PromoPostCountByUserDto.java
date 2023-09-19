package bootcamp.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostCountByUserDto {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
