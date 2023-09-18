package bootcamp.socialMeli.repository;

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
    public Optional<User> removeFollower(int userId, int userIdToUnfollow)  {

        Optional<User> user = Optional.ofNullable(usersDatabase.get(userId));
        Optional<User> userToUnfollow = Optional.ofNullable(usersDatabase.get(userIdToUnfollow));

        user.get().getFollowing().removeIf(followedId -> followedId == userIdToUnfollow);
        userToUnfollow.get().getFollowers().removeIf(followerId -> followerId == userId);

        return user;
    }

    @Override
    public Optional<User> findUserById(Integer userId) {
        return Optional.ofNullable(this.usersDatabase.get(userId));
    }

    @Override
    public void addFollower(User user, User userToFollow) {
        user.getFollowing().add(userToFollow.getUser_id());
        userToFollow.getFollowers().add(user.getUser_id());
    }
}
