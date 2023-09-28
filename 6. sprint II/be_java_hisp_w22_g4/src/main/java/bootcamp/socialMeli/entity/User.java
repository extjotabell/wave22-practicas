package bootcamp.socialMeli.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonProperty("user_id")
    private Integer userId;
    private RolEnum rol;
    @JsonProperty("user_name")
    private String userName;
    private List<Integer> postList;
    private List<Integer> followed;
    private List<Integer> followers;

    public List<Integer> getFollowed() {
        if (followed == null) return new ArrayList<>();
        return followed;
    }

    public List<Integer> getFollowers() {
        if (followers == null) return new ArrayList<>();
        return followers;
    }

    public List<Integer> getPostList() {
        if (postList == null) return new ArrayList<>();
        return postList;
    }
}
