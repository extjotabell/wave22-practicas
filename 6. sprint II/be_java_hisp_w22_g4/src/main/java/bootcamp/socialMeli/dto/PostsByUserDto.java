package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsByUserDto {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("userName")
    private String userName;
    private List<PostDto> posts;
}
