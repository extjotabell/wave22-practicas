package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.User;

import java.util.List;

public interface IUserService {
    List<UserDto> getAllUsers();

    FollowersListDto getFollowersList(int userId, NameOrderEnumDto nameOrder);

    FollowersCountDto getFollowersCount(int userId);

    User findUserById(int userId);

    void followUser(Integer userId, Integer userIdToFollow);

}
