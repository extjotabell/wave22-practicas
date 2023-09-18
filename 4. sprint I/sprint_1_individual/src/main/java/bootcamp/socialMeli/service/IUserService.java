package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.User;

import java.util.List;

public interface IUserService {

    List<UserDto> getAllUsers();
    UserDto removeFollower(int userId, int userIdToUnfollow);

    FollowersListDto getFollowersList(int userId, NameOrderEnumDto nameOrder);

    FollowedListDto getFollowingList(int userId, NameOrderEnumDto nameOrder);

    FollowersCountDto getFollowersCount(int userId);

    User findUserById(int userId);

    void followUser(Integer userId, Integer userIdToFollow);

    void addPostIdToUser(int userId, int postId);

    String getUserNameById(int userId);

}
