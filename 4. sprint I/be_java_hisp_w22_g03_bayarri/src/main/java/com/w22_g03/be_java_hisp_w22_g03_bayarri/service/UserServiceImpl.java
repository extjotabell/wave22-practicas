package com.w22_g03.be_java_hisp_w22_g03_bayarri.service;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.*;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.exception.BadRequestException;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.exception.NotFoundException;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.User;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseDTO startFollowing(int userId, int userIdToFollow) {
        if (userId == userIdToFollow) {
            throw new BadRequestException("User can't add themselves.");
        }
        User newFollower = findById(userId);
        User userToFollow = findById(userIdToFollow);
        if (!userToFollow.isSeller()) {
            throw new BadRequestException("User is not seller.");
        }
        if (newFollower.getFollowed().contains(userToFollow)) {
            throw new BadRequestException("User cant follow the same seller more than once.");
        }
        userToFollow.addFollower(newFollower);
        newFollower.addFollowed(userToFollow);
        return new ResponseDTO(userId + " successfully followed " + userIdToFollow);
    }

    @Override
    public ResponseDTO stopFollowing(int userId, int userIdToUnfollow) {
        if (userId == userIdToUnfollow) {
            throw new BadRequestException("User can't unfollow themselves.");
        }
        User follower = findById(userId);
        User userToUnfollow = findById(userIdToUnfollow);
        if (!follower.getFollowed().contains(userToUnfollow)) {
            throw new BadRequestException("You are not a follower of this user.");
        }

        userToUnfollow.popFollower(follower);
        follower.popFollowed(userToUnfollow);
        return new ResponseDTO(userId + " successfully unfollowed " + userIdToUnfollow);
    }

    @Override
    public NumberOfFollowersDTO getNumberOfFollowers(int userId) {
        User user = findById(userId);
        return new NumberOfFollowersDTO(userId, user.getUsername(), user.getFollowers().size());
    }

    @Override
    public FollowerDTO getFollowers(int userId, String order) {
        User user = findById(userId);
        List<User> followers = userRepository.findFollowers(userId);
        List<UserDTO> followerDTOS = new ArrayList<>();
        if (order != null) {
            if (order.equals("name_asc"))
                followers = followers.stream().sorted(Comparator.comparing(User::getUsername)).toList();
            else if (order.equals("name_desc"))
                followers = followers.stream().sorted(Comparator.comparing(User::getUsername).reversed()).toList();
            else throw new BadRequestException("Not valid order parameter. Use 'name_asc' or 'name_desc'");
        }
        for (User u : followers) {
            followerDTOS.add(new UserDTO(u.getUserId(), u.getUsername()));
        }
        return FollowerDTO.buildFollowerDTO(new UserDTO(user.getUserId(), user.getUsername()), followerDTOS);
    }

    @Override
    public FollowedDTO getFollowed(int userId, String order) {
        User user = findById(userId);
        List<User> followed = userRepository.findFollowed(userId);
        List<UserDTO> followedDTOS = new ArrayList<>();
        if (order != null) {
            if (order.equals("name_asc"))
                followed = followed.stream().sorted(Comparator.comparing(User::getUsername)).toList();
            else if (order.equals("name_desc"))
                followed = followed.stream().sorted(Comparator.comparing(User::getUsername).reversed()).toList();
            else throw new BadRequestException("Not valid order parameter. Use 'name_asc' or 'name_desc'");
        }
        for (User u : followed) {
            followedDTOS.add(new UserDTO(u.getUserId(), u.getUsername()));
        }
        return FollowedDTO.buildFollowedDTO(new UserDTO(user.getUserId(), user.getUsername()), followedDTOS);
    }

    @Override
    public User findById(long userId) {
        User user = userRepository.findById(userId);
        if (Objects.isNull(user)) {
            throw new NotFoundException("User not found");
        }
        return user;
    }
}
