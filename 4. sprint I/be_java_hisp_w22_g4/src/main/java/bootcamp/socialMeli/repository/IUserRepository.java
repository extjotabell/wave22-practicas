package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> getAllUsers();
    Optional<User> removeFollower(int userId, int userIdToUnfollow);
    Optional<User> findUserById(Integer userId);
    void addFollower(User user, User userToFollow);
}
