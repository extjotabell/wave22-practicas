package bootcamp.socialMeli.unitTests.service.userService;

import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IUserRepository;

import bootcamp.socialMeli.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UnfollowUserTest {
    @Mock
    IUserRepository userRepository;
    @Mock
    ObjectMapper mapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-0002: Unfollow user ok")
    void unfollowUserOk(){
        //Arrange
        User userTest = new User(1, RolEnum.COMPRADOR,"user test comprador", List.of(), List.of(2),List.of());
        User userToUnfollowTest = new User(2, RolEnum.VENDEDOR,"user test vendedor", List.of(), List.of(), List.of(1));
        UserDto userTestDto = new UserDto();
        userTestDto.setUserId(1);

        //Act
        when(userRepository.findUserById(userTest.getUserId())).thenReturn(Optional.of(userTest));
        when(userRepository.findUserById(userToUnfollowTest.getUserId())).thenReturn(Optional.of(userToUnfollowTest));
        when(mapper.convertValue(any(), eq(UserDto.class))).thenReturn(userTestDto);

        UserDto result = userService.removeFollower(userTest.getUserId(), userToUnfollowTest.getUserId());

        //Assert
        assertEquals(1, result.getUserId());
        verify(userRepository, atLeastOnce()).removeFollower(userTest, userToUnfollowTest);

    }

    @Test
    @DisplayName("T-0002: Unfollow non existing user")
    void unfollowUserNotOk(){
        //Arrange
        User userTest = new User(1, RolEnum.COMPRADOR,"user test comprador", List.of(), List.of(2),List.of());
        User userToUnfollowTest = new User(2, RolEnum.VENDEDOR,"user test vendedor", List.of(), List.of(), List.of(1));

        //Act
        when(userRepository.findUserById(userTest.getUserId())).thenReturn(Optional.of(userTest));
        when(userRepository.findUserById(userToUnfollowTest.getUserId())).thenReturn(Optional.empty());

        //Assert
        assertThrows(NotFoundException.class,()->userService.removeFollower(userTest.getUserId(), userToUnfollowTest.getUserId()));
    }
}
