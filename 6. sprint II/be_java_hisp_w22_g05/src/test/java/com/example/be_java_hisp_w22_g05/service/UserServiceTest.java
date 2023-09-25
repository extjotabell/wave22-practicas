package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.FollowException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T-0001: Prueba exitosa de follow")
    void followUserOk(){
        //Arrange
        User user = new User(1,"carlos",new ArrayList<>(),new ArrayList<>());
        User userToFollow = new User(2,"maria",new ArrayList<>(),new ArrayList<>());

        //Usuario que debe quedar luego de hacer el follow (tiene un item en la lista de followed)
        User userAfterFollow = new User(1,"carlos",new ArrayList<>(), List.of(userToFollow));

        UserFollowedDto expected = new UserFollowedDto(userAfterFollow.getId(),userAfterFollow.getName(),userAfterFollow.getFollowed().stream()
                .map(u -> new UserDto(u.getId(), u.getName()))
                .collect(Collectors.toList()));

        when(userRepository.findUsersById(user.getId())).thenReturn(user);
        when(userRepository.findUsersById(userToFollow.getId())).thenReturn(userToFollow);
        when(userRepository.follow(user, userToFollow)).thenReturn(userAfterFollow);

        //Act
        UserFollowedDto result = userService.followUser(user.getId(), userToFollow.getId());

        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("T-0001: El usuario a seguir no existe")
    void followNonExistingUser(){
        //Arrange
        User user = new User(1,"carlos",new ArrayList<>(),new ArrayList<>());
        int userIdToFollow = 0;

        when(userRepository.findUsersById(user.getId())).thenReturn(user);
        when(userRepository.findUsersById(0)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(NotFoundException.class, ()-> userService.followUser(user.getId(), userIdToFollow));
    }

    @Test
    @DisplayName("T-0002: Prueba exitosa de unfollow")
    void unfollowUserOk(){
        //Arrange
        User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(2,"maria", new ArrayList<>(), new ArrayList<>());
        User userAfterUnfollow = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
        user.getFollowed().add(userToUnfollow);
        userToUnfollow.getFollower().add(user);

        UserFollowedDto expected = new UserFollowedDto(userAfterUnfollow.getId(),userAfterUnfollow.getName(),userAfterUnfollow.getFollowed().stream()
                .map(u -> new UserDto(u.getId(), u.getName()))
                .collect(Collectors.toList()));

        when(userRepository.findUsersById(user.getId())).thenReturn(user);
        when(userRepository.findUsersById(userToUnfollow.getId())).thenReturn(userToUnfollow);
        when(userRepository.unfollow(user, userToUnfollow)).thenReturn(userAfterUnfollow);

        //Act
        UserFollowedDto result = userService.unfollowUser(user.getId(), userToUnfollow.getId());

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0002: No existe el usuario a dejar de seguir")
    void unfollowUserNotFound(){
        //Arrange
        User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
        int userIdToUnfollow = 2;

        UserFollowedDto expected = new UserFollowedDto(user.getId(), user.getName(),
                user.getFollowed().stream().map(u -> new UserDto(u.getId(), u.getName())).collect(Collectors.toList()));

        when(userRepository.findUsersById(user.getId())).thenReturn(user);
        when(userRepository.findUsersById(userIdToUnfollow)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(NotFoundException.class, ()-> userService.unfollowUser(user.getId(), userIdToUnfollow));
    }


}
