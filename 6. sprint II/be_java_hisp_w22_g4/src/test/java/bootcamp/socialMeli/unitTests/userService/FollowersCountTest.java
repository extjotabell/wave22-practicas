package bootcamp.socialMeli.unitTests.userService;

import bootcamp.socialMeli.dto.FollowersCountDto;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IUserRepository;
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
class FollowersCountTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("US 02 - FollowersCount OK")
    void getFollowersCountOk(){
        //Arrange
        User userToCheck = new User(1, RolEnum.COMPRADOR, "UsuarioComprador", List.of(), List.of(), List.of());
        FollowersCountDto expectedResult = new FollowersCountDto(1, "UsuarioComprador", 0);

        //Act
        when(userRepository.findUserById(userToCheck.getUserId())).thenReturn(Optional.of(userToCheck));

        //Assert
        Assertions.assertEquals(expectedResult, userService.getFollowersCount(1));
    }

    @Test
    @DisplayName("US 02 - FollowersCount Not Found")
    void getFollowersCountNotFound(){
        //Arrange
        int nonExistentUserId = -1;

        //Act
        when(userRepository.findUserById(nonExistentUserId)).thenReturn(Optional.empty());

        //Assert
        Assertions.assertThrows(
                NotFoundException.class,
                () -> this.userService.getFollowersCount(nonExistentUserId)
        );
    }
}
