package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DiscountedPostDto extends PostDto {
    @NotNull(message = "Test")
    private Boolean has_promo;

    @NotNull(message = "Test")
    private Double discount;

    public DiscountedPostDto(int user_id, int post_id, LocalDate date, ProductDto product, int category, double price, Boolean has_promo, Double discount) {
        super(user_id, post_id, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public Boolean getHas_promo() {
        return has_promo;
    }

    public void setHas_promo(Boolean has_promo) {
        this.has_promo = has_promo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
