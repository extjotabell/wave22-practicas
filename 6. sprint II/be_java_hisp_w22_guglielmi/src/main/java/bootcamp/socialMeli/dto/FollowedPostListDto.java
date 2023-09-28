package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowedPostListDto {
    @JsonProperty("user_id")
    private Integer userId;
    private List<PostDto> posts;
}
