package bootcamp.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostListByUserDto {
    private int user_id;
    private String user_name;
    private List<PromoPostDto> posts;
}
