package bootcamp.socialMeli.unitTests.userService;

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
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
        User userTest = new User(1, RolEnum.COMPRADOR,"user test comprador", List.of(), List.of(2),List.of());
        User userToUnfollowTest = new User(2, RolEnum.VENDEDOR,"user test vendedor", List.of(), List.of(), List.of(1));
        UserDto userDto = new UserDto();
        userDto.setUserId(1);

        when(userRepository.findUserById(userTest.getUserId())).thenReturn(Optional.of(userTest));
        when(userRepository.findUserById(userToUnfollowTest.getUserId())).thenReturn(Optional.of(userToUnfollowTest));
        when(mapper.convertValue(any(), eq(UserDto.class))).thenReturn(userDto);

        UserDto result = userService.removeFollower(userTest.getUserId(), userToUnfollowTest.getUserId());
        assertEquals(1, result.getUserId());
        verify(userRepository, atLeastOnce()).removeFollower(userTest, userToUnfollowTest);

    }

    @Test
    @DisplayName("T-0002: Unfollow user not ok")
    void unfollowUserNotOk(){
        User userTest = new User(1, RolEnum.COMPRADOR,"user test comprador", List.of(), List.of(2),List.of());
        User userToUnfollowTest = new User(2, RolEnum.VENDEDOR,"user test vendedor", List.of(), List.of(), List.of(1));

        when(userRepository.findUserById(userTest.getUserId())).thenReturn(Optional.of(userTest));
        when(userRepository.findUserById(userToUnfollowTest.getUserId())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class,()->userService.removeFollower(userTest.getUserId(), userToUnfollowTest.getUserId()));
    }
}
