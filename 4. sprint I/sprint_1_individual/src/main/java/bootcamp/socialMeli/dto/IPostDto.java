package bootcamp.socialMeli.dto;

import java.time.LocalDate;

public interface IPostDto {
    int getUser_id();
    int getPost_id();
    LocalDate getDate();
    ProductDto getProduct();
    int getCategory();
    double getPrice();
    boolean has_promo();
    double discount();
}
