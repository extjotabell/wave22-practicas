package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDto {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("followers_count")
    private int followersCount;
}
