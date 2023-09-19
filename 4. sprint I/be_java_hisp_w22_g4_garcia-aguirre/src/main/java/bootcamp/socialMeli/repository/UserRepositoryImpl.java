package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    private HashMap<Integer, User> usersDatabase;

    public UserRepositoryImpl() {
        this.usersDatabase = loadUsers();
    }

    private HashMap<Integer, User> loadUsers(){
        List<User> users = loadDataBase();
        HashMap<Integer, User> usersHashmap = new HashMap<>();

        for (User user : users) {
            usersHashmap.put(user.getUser_id(), user);
        }

        return usersHashmap;
    }

    private List<User> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return usersDatabase.values().stream().toList();
    }

    @Override
    public User removeFollower(User user, User userToUnfollow)  {

        user.getFollowed().removeIf(followedId -> followedId == userToUnfollow.getUser_id());
        userToUnfollow.getFollowers().removeIf(followerId -> followerId == user.getUser_id());

        return user;
    }

    @Override
    public Optional<User> findUserById(Integer userId) {
        return Optional.ofNullable(this.usersDatabase.get(userId));
    }

    @Override
    public void addFollower(User user, User userToFollow) {
        user.getFollowed().add(userToFollow.getUser_id());
        userToFollow.getFollowers().add(user.getUser_id());
    }

    @Override
    public void addPostToUser(User owner, int postId) {
        owner.setRol(RolEnum.VENDEDOR);
        owner.getPostList().add(postId);
    }
}
