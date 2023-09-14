package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUsers();

}
