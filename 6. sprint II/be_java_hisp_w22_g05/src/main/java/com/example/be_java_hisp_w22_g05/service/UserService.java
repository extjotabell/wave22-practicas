package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowersDto;
import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.FollowException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
    public UserFollowedDto followUser(int followerId, int userToFollowId) {
        //Validations
        if (followerId == userToFollowId){
            throw new FollowException("El usuario no puede seguirse a si mismo!");
        }
        //Search Users
        User follower = userRepository.findUsersById(followerId);
        User userToFollow = userRepository.findUsersById(userToFollowId);

        //Validations
        if(follower == null || userToFollow == null){
            throw new NotFoundException("Uno de los usuarios no existe");
        }
        if(follower.getFollowed().contains(userToFollow)){
            throw new FollowException("El usuario " + followerId + " ya sigue al usuario " + userToFollowId);
        }

        //Follow
        follower = userRepository.follow(follower,userToFollow);
        
        return new UserFollowedDto(follower.getId(),follower.getName(),follower.getFollowed().stream()
                .map(user -> new UserDto(user.getId(), user.getName()))
                .collect(Collectors.toList()));
    }

    public UserNumberFollowersDto getNumberFollowers(int userId) {
        User user = userRepository.findUsersById(userId);
        if (user == null) {
            throw new NotFoundException("Usuario " + userId + " no encontrado");
        }
        return new UserNumberFollowersDto(userId, user.getName(), user.getFollower().size());
    }

    public UserFollowedDto getListOfUsersFollowedBy(Integer id, String order){
        User user = userRepository.findUsersById(id);
        if(user == null){
            throw new NotFoundException("No se encontró el usuario " + id);
        }
        UserFollowedDto userFollowedDto = new UserFollowedDto();
        userFollowedDto.setId(user.getId());
        userFollowedDto.setUserName(user.getName());
        List<UserDto> userDtos = new ArrayList<>();
        for (User u : user.getFollowed()) {
            userDtos.add(new UserDto(u.getId(), u.getName()));
        }
        userDtos = orderList(userDtos, order);
        userFollowedDto.setFollowed(userDtos);
        return userFollowedDto;
    }

    public UserFollowedDto unfollowUser(int userId, int userIdToUnfollow) {
        User userFollower = userRepository.findUsersById(userId);
        if(userFollower == null){
            throw new NotFoundException("No se encontro el usuario " + userId);
        }
        User userFollowed = userRepository.findUsersById(userIdToUnfollow);
        if(userFollowed == null){
            throw new NotFoundException("No se encontro el usuario " + userIdToUnfollow);
        }
        User userFollowedInFollower = userFollower.getFollowed().stream().filter(u-> u == userFollowed).findFirst().orElse(null);
        if(userFollowedInFollower == null){
            throw new NotFoundException("No seguis al usuario con id " + userIdToUnfollow);
        }
        User finalUser = userRepository.unfollow(userFollower,userFollowed);
        List<UserDto> userFollowedFinal = finalUser.getFollowed().stream().map(f-> new UserDto(f.getId(),f.getName())).toList();
        return new UserFollowedDto(finalUser.getId(), finalUser.getName(),userFollowedFinal);

    }
    public UserFollowersDto findUsersFollowingSeller(int userId, String order) {
        User user = userRepository.findUsersById(userId);
        if (user == null) {
            throw new NotFoundException("No se encontró el usuario " + userId);
        }

        List<UserDto> userDtos = user.getFollower()
                .stream()
                .map(user1 -> new UserDto(user1.getId(), user1.getName()))
                .collect(Collectors.toList());

        userDtos = orderList(userDtos, order);
        return new UserFollowersDto(user.getId(), user.getName(), userDtos) ;
    }

    private List<UserDto> orderList(List<UserDto> userDtos, String order){
        if("name_asc".equals(order)){
            return userDtos.stream().sorted(Comparator.comparing(UserDto::getName)).collect(Collectors.toList());
        }
        else if ("name_desc".equals(order)){
            return userDtos.stream().sorted(Comparator.comparing(UserDto::getName).reversed()).collect(Collectors.toList());

        }
        else{
            throw new NotFoundException("El tipo de ordenamiento solicitado no existe");
        }
    }
}
