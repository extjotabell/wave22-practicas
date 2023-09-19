package bootcamp.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDto {
    private int user_id;
    private String user_name;
    List<DiscountedPostDto> postDtoList;
}
