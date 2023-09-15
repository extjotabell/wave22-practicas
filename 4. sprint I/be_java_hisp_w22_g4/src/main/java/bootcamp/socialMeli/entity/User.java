package bootcamp.socialMeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int user_id;
    private RolEnum rol;
    private String user_name;
    private List<Integer> postList;
    private List<Integer> following;
    private List<Integer> followers;

    public List<Integer> getFollowing() {
        if (following == null) return new ArrayList<>();
        return following;
    }

    public List<Integer> getFollowers() {
        if (followers == null) return new ArrayList<>();
        return followers;
    }

    public boolean isBeingFollowedBy(int followerId){
        return followers.stream().anyMatch(id -> id == followerId);
    }

    public boolean isFollowing(int userId){
        return following.stream().anyMatch(id -> id == userId);
    }

}
