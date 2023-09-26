package bootcamp.socialMeli.unitTests.userService;

import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.UserRepositoryImpl;
import bootcamp.socialMeli.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FollowUserTest {
    @Mock
    private UserRepositoryImpl userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    @DisplayName("[T-0001 / US-0001] - Follow user OK")
    void followUserOk(){
        //Arrange
        User user = new User(1, RolEnum.COMPRADOR, "UsuarioComprador", List.of(), List.of(), List.of());
        User userToFollow = new User(2, RolEnum.VENDEDOR, "UsuarioSeguidor", List.of(15), List.of(), List.of());

        //Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(userToFollow.getUserId())).thenReturn(Optional.of(userToFollow));

        userService.followUser(1, 2);

        //Assert
        verify(userRepository, atLeastOnce()).addFollower(user, userToFollow);
    }

    @Test
    @DisplayName("[US-0001] - Follow user with same id")
    void followUserWithSameId(){
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 1;

        //Assert
        Assertions.assertThrows(BadRequestException.class, () -> this.userService.followUser(userId, userIdToFollow));
    }

    @Test
    @DisplayName("[US-0001] - Trying to follow COMPRADOR")
    void followingComprador(){
        //Arrange
        User user = new User(1, RolEnum.COMPRADOR, "UsuarioComprador", List.of(), List.of(), List.of());
        User userToFollow = new User(2, RolEnum.COMPRADOR, "UsuarioSeguidor", List.of(15), List.of(), List.of());

        //Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(userToFollow.getUserId())).thenReturn(Optional.of(userToFollow));

        //Assert
        Assertions.assertThrows(
                BadRequestException.class,
                () -> this.userService.followUser(user.getUserId(), userToFollow.getUserId())
        );
    }

    @Test
    @DisplayName("[US-0001] - Follow an already followed user")
    void followAlreadyFollowed(){
        //Arrange
        User user = new User(1, RolEnum.COMPRADOR, "UsuarioComprador", List.of(), List.of(2), List.of());
        User userToFollow = new User(2, RolEnum.VENDEDOR, "UsuarioSeguidor", List.of(15), List.of(), List.of(1));

        //Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(userToFollow.getUserId())).thenReturn(Optional.of(userToFollow));

        //Assert
        Assertions.assertThrows(
                BadRequestException.class,
                () -> this.userService.followUser(user.getUserId(), userToFollow.getUserId())
        );
    }

    @Test
    @DisplayName("[T-0001 / US-0001] - Follow non existing user")
    void followNonExistingUser(){
        //Arrange
        User user = new User(1, RolEnum.COMPRADOR, "UsuarioComprador", List.of(), List.of(2), List.of());

        //Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(-4)).thenReturn(Optional.empty());

        //Assert
        Assertions.assertThrows(
                NotFoundException.class,
                () -> this.userService.followUser(user.getUserId(), -4)
        );
    }
}
