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
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

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

    public UserFollowedDto getListOfUsersFollowedBy(Integer id){
        User user = userRepository.findUsersById(id);
        if(user == null){
            throw new NotFoundException("No se encontró el usuario especificado");
        }
        UserFollowedDto userFollowedDto = new UserFollowedDto();
        userFollowedDto.setId(user.getId());
        userFollowedDto.setUserName(user.getName());
        List<UserDto> userDtos = new ArrayList<>();
        for (User u : user.getFollowed()) {
            userDtos.add(new UserDto(u.getId(), u.getName()));
        }
        userFollowedDto.setFollowed(userDtos);
        return userFollowedDto;
    }

    public UserFollowedDto unfollow(int userId, int userIdToUnfollow) {
        User userFollower = userRepository.findUsersById(userId);
        if(userFollower == null){
            throw new NotFoundException("No se encontro el usuario " + userId);
        }
        User userFollowed = userRepository.findUsersById(userIdToUnfollow);
        if(userFollowed == null){
            throw new NotFoundException("No se encontro el usuario " + userIdToUnfollow);
        }
        User finalUser = userRepository.unfollow(userFollower,userFollowed);
        List<UserDto> userFollowedFinal = finalUser.getFollowed().stream().map(f-> new UserDto(f.getId(),f.getName())).toList();
        return new UserFollowedDto(finalUser.getId(), finalUser.getName(),userFollowedFinal);

    }
}
