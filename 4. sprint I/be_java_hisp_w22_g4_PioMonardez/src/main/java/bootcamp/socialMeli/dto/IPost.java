package bootcamp.socialMeli.dto;

import java.time.LocalDate;

public interface IPost {
    int get_user_id();
    int get_post_id();
    LocalDate get_date();
    ProductDto get_product();
    int get_category();
    double get_price();
    boolean get_has_promo();
    double get_discount();
}
