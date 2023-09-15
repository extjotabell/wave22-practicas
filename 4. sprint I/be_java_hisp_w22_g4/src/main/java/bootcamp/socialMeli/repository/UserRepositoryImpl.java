package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public User getUserById(int userId) {
        if (!usersDatabase.containsKey(userId)) {
            throw new NotFoundException("Usuario con ID #" + userId + " no encontrado");
        }
        return usersDatabase.get(userId);
    }

}
