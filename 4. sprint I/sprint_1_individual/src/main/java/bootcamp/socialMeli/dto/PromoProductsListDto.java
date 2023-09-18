package bootcamp.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PromoProductsListDto {
    int user_id;
    String user_name;
    List<PromoPostDto> posts;
}
