package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersListDto {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("userName")
    private String userName;
    private List<UserDto> followers;
}
