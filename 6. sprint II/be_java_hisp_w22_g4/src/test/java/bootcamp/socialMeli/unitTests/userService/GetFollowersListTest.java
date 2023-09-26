package bootcamp.socialMeli.unitTests.userService;

import bootcamp.socialMeli.dto.FollowersListDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.UserRepositoryImpl;
import bootcamp.socialMeli.service.UserServiceImpl;
import bootcamp.socialMeli.utils.NameOrderEnumDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetFollowersListTest {
    @Mock
    private UserRepositoryImpl userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    private static User userExpected6;
    private static User userExpected1;
    private static User userExpected10;

    @BeforeAll
    static void SetUp(){
        List<Integer> postList = new ArrayList<>(){{add(1);add(2);}};
        List<Integer> followe = new ArrayList<>(){{add(7);add(8);}};;
        List<Integer> followers = new ArrayList<>(){{add(1);add(10);}};
        userExpected6 = new User(6, RolEnum.VENDEDOR,"Jesica",postList,followe,followers);
        List<Integer> followe1 = new ArrayList<>(){{add(6);add(10);}};;

        userExpected1 = new User(1, RolEnum.COMPRADOR, "Diego", null, followe1, null);
        List<Integer> postList10 = new ArrayList<>(){{add(100);}};
        List<Integer> followe10 = new ArrayList<>(){{add(1);add(2);add(7);add(10);}};;
        List<Integer> followers10 = new ArrayList<>(){{add(6);add(7);}};
        userExpected10 = new User(10, RolEnum.VENDEDOR,"Hector",postList10,followe10,followers10);
    }

    @Test
    @DisplayName("US 03 - List Follow ASC OK")
    void FollowersListNameAscOk() {
        //Arrange
        FollowersListDto followerExpected = new FollowersListDto(6, "Jesica", List.of(
                new UserDto(1, "Diego"),
                new UserDto(10, "Hector")));
        int UserId = 6;
        NameOrderEnumDto order = NameOrderEnumDto.name_asc;
        //Act
        when(userRepository.findUserById(UserId)).thenReturn(Optional.of(userExpected6));
        when(userRepository.findUserById(userExpected6.getFollowers().get(0))).thenReturn(Optional.of(userExpected1));
        when(userRepository.findUserById(userExpected6.getFollowers().get(1))).thenReturn(Optional.of(userExpected10));
        FollowersListDto followerActual = userService.getFollowersList(UserId,order);
        //Assert
        Assertions.assertEquals(followerExpected,followerActual);
    }
    @Test
    @DisplayName("US 03 - List Follow DESC OK")
    void FollowersListNameDescOk() {
        //Arrange
        FollowersListDto followerExpected = new FollowersListDto(6, "Jesica", List.of(
                new UserDto(10, "Hector"),
                new UserDto(1, "Diego")));
        int UserId = 6;
        NameOrderEnumDto order = NameOrderEnumDto.name_desc;
        //Act
        when(userRepository.findUserById(UserId)).thenReturn(Optional.of(userExpected6));
        when(userRepository.findUserById(userExpected6.getFollowers().get(0))).thenReturn(Optional.of(userExpected1));
        when(userRepository.findUserById(userExpected6.getFollowers().get(1))).thenReturn(Optional.of(userExpected10));
        FollowersListDto followerActual = userService.getFollowersList(UserId,order);
        //Assert
        Assertions.assertEquals(followerExpected,followerActual);
    }
    @Test
    @DisplayName("US 03 - List Follow Not param Order Ok")
    void FollowersListNameNotParamOrderOk() {
        //Arrange
        FollowersListDto followerExpected = new FollowersListDto(6, "Jesica", List.of(
                new UserDto(1, "Diego"),
                new UserDto(10, "Hector")));
        int UserId = 6;
        //Act
        when(userRepository.findUserById(UserId)).thenReturn(Optional.of(userExpected6));
        when(userRepository.findUserById(userExpected6.getFollowers().get(0))).thenReturn(Optional.of(userExpected1));
        when(userRepository.findUserById(userExpected6.getFollowers().get(1))).thenReturn(Optional.of(userExpected10));
        FollowersListDto followerActual = userService.getFollowersList(UserId,null);
        //Assert
        Assertions.assertEquals(followerExpected,followerActual);
    }
    @Test
    @DisplayName("US 03 - List Follow Not Found")
    void FollowersListNameNotFound() {
        //Arrange
        FollowersListDto followerExpected = null;
        int UserId = 25;
        NameOrderEnumDto order = NameOrderEnumDto.name_desc;
        //Act
        when(userRepository.findUserById(UserId)).thenReturn(Optional.empty());
        //Assert
        Assertions.assertThrows(NotFoundException.class, () -> this.userService.getFollowersList(UserId,order));

    }
}
