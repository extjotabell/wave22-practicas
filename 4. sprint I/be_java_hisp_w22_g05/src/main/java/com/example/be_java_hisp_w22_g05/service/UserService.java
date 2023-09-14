package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.FollowException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final IUserRepository userRepository;

    @Override
    public UserFollowedDto follow(int followerId, int userToFollowId) {
        if (followerId == userToFollowId){
            throw new FollowException("User cant follow himsef!");
        }
        User follower = userRepository.findUsersById(followerId);
        User userToFollow = userRepository.findUsersById(userToFollowId);
        if(follower == null || userToFollow == null){
            throw new NotFoundException("User not found!");
        }
        if(follower.getFollowed().contains(userToFollow)){
            throw new FollowException("User already follow!");
        }
        follower.getFollowed().add(userToFollow);
        userToFollow.getFollower().add(follower);

        List<UserDto> followedList = new ArrayList<>();
        for (User user:follower.getFollowed()) {
            followedList.add(new UserDto(user.getId(),user.getName()));
        }
        return new UserFollowedDto(follower.getId(),follower.getName(),followedList);
    }
}
