package bootcamp.socialMeli.unitTests.userController;

import bootcamp.socialMeli.controller.UserController;
import bootcamp.socialMeli.dto.FollowersListDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.service.UserServiceImpl;
import bootcamp.socialMeli.utils.NameOrderEnumDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetFollowersListTest {
    @Mock
    private UserServiceImpl userService;
    @InjectMocks
    private UserController userController;
    @Test
    @DisplayName("US 03 - List Follow Not param Order Ok")
    void FollowersListNameNotParamOrderOk() {
        //Arrange
        int UserId = 6;
        FollowersListDto followerExpected = new FollowersListDto(6, "Jesica", List.of(
                new UserDto(1, "Diego"),
                new UserDto(10, "Hector")));
        //Act
        when(userService.getFollowersList(UserId,null)).thenReturn(followerExpected);
        ResponseEntity<FollowersListDto> followerActual = userController.getFollowersList(UserId,null);
        //Assert
        Assertions.assertEquals(followerExpected,followerActual.getBody());
    }

    @Test
    @DisplayName("US 03 - List Follow Not param Order Ok")
    void FollowersListNameParamInvalid() {
        //Arrange
        int UserId = 6;
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.userController.getFollowersList(UserId,NameOrderEnumDto.valueOf("jkhjk")));

    }
}
