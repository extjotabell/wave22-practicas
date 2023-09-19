package bootcamp.socialMeli.dto;

import java.time.LocalDate;

public interface IPost {
    int user_id();
    int post_id();
    LocalDate date();
    ProductDto product();
    int category();
    double price();
    boolean has_promo();
    double discount();
}
