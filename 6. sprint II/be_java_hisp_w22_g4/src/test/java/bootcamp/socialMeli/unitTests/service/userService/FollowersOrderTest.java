package bootcamp.socialMeli.unitTests.service.userService;

import bootcamp.socialMeli.dto.FollowedListDto;
import bootcamp.socialMeli.dto.FollowersListDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.repository.UserRepositoryImpl;
import bootcamp.socialMeli.service.UserServiceImpl;
import bootcamp.socialMeli.utils.NameOrderEnumDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FollowersOrderTest {
    @Mock
    private UserRepositoryImpl userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("T-0004 - US-08 - Get followers list in ascending order")
    void getFollowersListAsc() {
        // Arrange
        User user = new User(1, RolEnum.VENDEDOR, "UsuarioA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower1 = new User(2, RolEnum.COMPRADOR, "UsuarioC", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(3, RolEnum.COMPRADOR, "UsuarioD", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower3 = new User(4, RolEnum.COMPRADOR, "UsuarioB", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user.getFollowers().add(follower1.getUserId());
        user.getFollowers().add(follower2.getUserId());
        user.getFollowers().add(follower3.getUserId());

        // Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(follower1));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(follower2));
        when(userRepository.findUserById(4)).thenReturn(Optional.of(follower3));
        FollowersListDto followersList = userService.getFollowersList(user.getUserId(), NameOrderEnumDto.name_asc);

        // Assert
        List<UserDto> followers = followersList.getFollowers();
        Assertions.assertEquals("UsuarioB", followers.get(0).getUserName());
        Assertions.assertEquals("UsuarioC", followers.get(1).getUserName());
        Assertions.assertEquals("UsuarioD", followers.get(2).getUserName());
    }

    @Test
    @DisplayName("T-0004 - US-08 - Get followers list in descending order")
    void getFollowersListDesc(){
        // Arrange
        User user = new User(1, RolEnum.VENDEDOR, "UsuarioA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower1 = new User(2, RolEnum.COMPRADOR, "UsuarioC", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(3, RolEnum.COMPRADOR, "UsuarioD", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower3 = new User(4, RolEnum.COMPRADOR, "UsuarioB", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user.getFollowers().add(follower1.getUserId());
        user.getFollowers().add(follower2.getUserId());
        user.getFollowers().add(follower3.getUserId());

        // Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(follower1));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(follower2));
        when(userRepository.findUserById(4)).thenReturn(Optional.of(follower3));
        FollowersListDto followersList = userService.getFollowersList(user.getUserId(), NameOrderEnumDto.name_desc);

        // Assert
        List<UserDto> followers = followersList.getFollowers();
        Assertions.assertEquals("UsuarioD", followers.get(0).getUserName());
        Assertions.assertEquals("UsuarioC", followers.get(1).getUserName());
        Assertions.assertEquals("UsuarioB", followers.get(2).getUserName());
    }

    @Test
    @DisplayName("US-08 - Get empty followers list")
    void getFollowersListEmpty(){
        // Arrange
        User user = new User(1, RolEnum.VENDEDOR, "UsuarioA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        FollowersListDto followersList = userService.getFollowersList(user.getUserId(), NameOrderEnumDto.name_asc);

        // Assert
        List<UserDto> followers = followersList.getFollowers();
        Assertions.assertTrue(followers.isEmpty(), "The followers list should be empty");

    }

    @Test
    @DisplayName("US-08 - Get following list in ascending order")
    void getFollowingListAsc() {
        // Arrange
        User user = new User(1, RolEnum.COMPRADOR, "UsuarioA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed1 = new User(2, RolEnum.VENDEDOR, "UsuarioC", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed2 = new User(3, RolEnum.VENDEDOR, "UsuarioD", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed3 = new User(4, RolEnum.VENDEDOR, "UsuarioB", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user.getFollowed().add(followed1.getUserId());
        user.getFollowed().add(followed2.getUserId());
        user.getFollowed().add(followed3.getUserId());

        // Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(followed1));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(followed2));
        when(userRepository.findUserById(4)).thenReturn(Optional.of(followed3));
        FollowedListDto followersList = userService.getFollowingList(user.getUserId(), NameOrderEnumDto.name_asc);

        // Assert
        List<UserDto> following = followersList.getFollowed();
        Assertions.assertEquals("UsuarioB", following.get(0).getUserName());
        Assertions.assertEquals("UsuarioC", following.get(1).getUserName());
        Assertions.assertEquals("UsuarioD", following.get(2).getUserName());
    }

    @Test
    @DisplayName("US-08 - Get following list in descending order")
    void getFollowingListDesc() {
        // Arrange
        User user = new User(1, RolEnum.COMPRADOR, "UsuarioA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed1 = new User(2, RolEnum.VENDEDOR, "UsuarioC", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed2 = new User(3, RolEnum.VENDEDOR, "UsuarioD", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed3 = new User(4, RolEnum.VENDEDOR, "UsuarioB", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user.getFollowed().add(followed1.getUserId());
        user.getFollowed().add(followed2.getUserId());
        user.getFollowed().add(followed3.getUserId());

        // Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(followed1));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(followed2));
        when(userRepository.findUserById(4)).thenReturn(Optional.of(followed3));
        FollowedListDto followersList = userService.getFollowingList(user.getUserId(), NameOrderEnumDto.name_desc);

        // Assert
        List<UserDto> following = followersList.getFollowed();
        Assertions.assertEquals("UsuarioD", following.get(0).getUserName());
        Assertions.assertEquals("UsuarioC", following.get(1).getUserName());
        Assertions.assertEquals("UsuarioB", following.get(2).getUserName());
    }

    @Test
    @DisplayName("US-08 - Get empty following list")
    void getFollowingListEmpty() {
        // Arrange
        User user = new User(1, RolEnum.COMPRADOR, "UsuarioA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Act
        when(userRepository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
        FollowedListDto followersList = userService.getFollowingList(user.getUserId(), NameOrderEnumDto.name_asc);

        // Assert
        List<UserDto> following = followersList.getFollowed();
        Assertions.assertTrue(following.isEmpty(), "The following list should be empty");
    }
}

