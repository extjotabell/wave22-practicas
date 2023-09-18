package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> getAllUsers();
    User removeFollower(User user, User userToUnfollow);
    Optional<User> findUserById(Integer userId);
    void addFollower(User user, User userToFollow);
    void addPostIdToUser(User user, int postId);
}
