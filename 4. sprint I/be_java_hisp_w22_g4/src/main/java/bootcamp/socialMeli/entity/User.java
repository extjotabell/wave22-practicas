package bootcamp.socialMeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int user_id;
    private RolEnum rol;
    private String user_name;
    private List<Post> postList;
    private List<Integer> following;
    private List<Integer> followers;
}
