package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;
import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.FollowException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public UserFollowedDto follow(int followerId, int userToFollowId) {
        //Validations
        if (followerId == userToFollowId){
            throw new FollowException("User cant follow himsef!");
        }
        //Search Users
        User follower = userRepository.findUsersById(followerId);
        User userToFollow = userRepository.findUsersById(userToFollowId);

        //Validations
        if(follower == null || userToFollow == null){
            throw new NotFoundException("User not found!");
        }
        if(follower.getFollowed().contains(userToFollow)){
            throw new FollowException("User already follow!");
        }

        //Follow
        follower.getFollowed().add(userToFollow);
        userToFollow.getFollower().add(follower);
        
        return new UserFollowedDto(follower.getId(),follower.getName(),follower.getFollowed().stream()
                .map(user -> new UserDto(user.getId(), user.getName()))
                .collect(Collectors.toList()));
    }

    public UserNumberFollowersDto getNumberFollowers(int userId) {
        User user = userRepository.findUsersById(userId);
        if (user == null) {
            throw new NotFoundException(String.format("User with id %d not found", userId));
        }
        return new UserNumberFollowersDto(userId, user.getName(), user.getFollower().size());
    }

}
