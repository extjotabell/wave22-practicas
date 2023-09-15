package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowersCountDto;
import bootcamp.socialMeli.dto.FollowersListDto;
import bootcamp.socialMeli.dto.NameOrderEnumDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.User;

import java.util.List;

public interface IUserService {

    List<UserDto> getAllUsers();
    UserDto removeFollower(int userId, int userIdToUnfollow);

    FollowersListDto getFollowersList(int userId, NameOrderEnumDto nameOrder);

    FollowersCountDto getFollowersCount(int userId);

    User findUserById(int userId);

    void followUser(Integer userId, Integer userIdToFollow);
}
