package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import com.example.be_java_hisp_w22_g02.dto.response.SuccessDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowerDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Product;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.example.be_java_hisp_w22_g02.enums.ResponseMessages.SUCCESSFUL_FOLLOW;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;
import static com.example.be_java_hisp_w22_g02.enums.ResponseMessages.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;
    @Mock
    ObjectMapper mapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName(value="T001 - Successfull follow - followUser")
    void followUser() {
        //ARRANGE
        int id = 1;
        int idToFollow = 2;
        List<Integer> follow = new ArrayList<>();
        follow.add(5);
        User user = new User(1,"test",follow,follow,null);

        when(userRepository.findById(any())).thenReturn(user);
        when(userRepository.existingUserById(any())).thenReturn(true);

         //ACT
        SuccessDTO actual = userService.followUser(id,idToFollow);

        //ASSERT
        assertEquals(SUCCESSFUL_FOLLOW.toString(),actual.getMessage());
    }
  
    @Test
    @DisplayName(value="T001 - Main user does not exist - followUser")
    void followUserWithIdNotFound() {

        assertThrows(NotFoundException.class,()->userService.followUser(1,2));
    }
  
    @Test
    @DisplayName("T002 - Unfollow Existent User - unfollowUser")
    void unfollowUserExistent() {
        //Arrange
        User user1 = new User(1, "pepito", List.of(), List.of(2), List.of());
        User user2 = new User(2, "juancito", List.of(1), List.of(), List.of());
        int idUserPrincipal = user1.getUserId();
        int idUserToUnfollow = user2.getUserId();
        SuccessDTO expectedSuccessDTO = new SuccessDTO(SUCCESSFUL_UNFOLLOW.toString());
        when(userRepository.existingUserById(idUserPrincipal)).thenReturn(true);
        when(userRepository.existingUserById(idUserToUnfollow)).thenReturn(true);
        when(userRepository.findById(idUserPrincipal)).thenReturn(user1);

        //Act
        SuccessDTO actualSuccessDTO = userService.unfollowUser(idUserPrincipal, idUserToUnfollow);

        //Assert
        assertEquals(expectedSuccessDTO, actualSuccessDTO);
    }

    @Test
    @DisplayName("T002 - Unfollow Nonexistent User - unfollowUser")
    void unfollowUserNonExistent() {
        //Arrange
        int idUserPrincipal = 1;
        int idUserToUnfollow = 999;
        when(userRepository.existingUserById(idUserPrincipal)).thenReturn(true);
        when(userRepository.existingUserById(idUserToUnfollow)).thenReturn(false);
        //Act

        //Assert
        assertThrows(NotFoundException.class, () -> userService.unfollowUser(idUserPrincipal, idUserToUnfollow));
    }

    @Test
    @DisplayName("T003 - Validate OK ascending alphabetic order - getFollowers")
    void getFollowers_OrderByNameAsc_ExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowers(1, "name_asc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());

    }

    @Test
    @DisplayName("T003 - Validate OK descending alphabetic order - getFollowers")
    void getFollowers_OrderByNameDesc_ExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowers(1, "name_desc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());

    }

    @Test
    @DisplayName("T003 - Validate exception when order is invalid - getFollowers")
    void getFollowers_OrderByName_NotExistTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act & Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowers(1, "name_ascc"));

    }

    @Test
    @DisplayName(value="T001 - Following a non existing user - followUser")
    void followUserWithIdNotFoundToFollow() {
        when(userRepository.existingUserById(1)).thenReturn(true);

        assertThrows(NotFoundException.class,()->userService.followUser(1,2));
    }

    @Test
    @DisplayName(value="T001 - Unable to autofollow - followUser ")
    void followUserWithSameId() {
        //ARRANGE
        when(userRepository.existingUserById(any())).thenReturn(true);

        assertThrows(BadRequestException.class,()->userService.followUser(1,1));
    }


    @Test
    @DisplayName("T003 - Validate OK ascending alphabetic order - getFollowed")
    void getFollowers() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowed(1, "name_asc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());
    }

    @Test
    @DisplayName("T003 - Throws exception with wrong id - getFollowed")
    void getFollowersWithIdDoesNotExist() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(false);
        assertThrows(NotFoundException.class,()->userService.getFollowed(1, "name_asc"));
    }

    @Test
    @DisplayName("T003 - Validate OK descending alphabetic order - getFollowed")
    void getFollowed_OrderByNameDesc_ExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowed(1, "name_desc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());

    }

    @Test
    @DisplayName("T003 - Validate exception when order is invalid - getFollowed")
    void getFollowed_OrderByName_NotExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act & Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowed(1, "name_ascc"));
    }

    @Test
    @DisplayName("T004 - Followers ordered correctly ASC - getFollowers")
    void getFollowers_order_asc_Test() {
        //arrange
        User user = new User(10,
                "miguelito",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(1, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        User user1 = new User(5,
                "carlos22",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(2, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        User user2 = new User(6,
                "mariapaz",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(2, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        User user3 = new User(1,
                "pepito1234",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(2, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        List<UserFollowDTO> userFollowDTOS = new ArrayList<>();
        userFollowDTOS.add(new UserFollowDTO(5, "carlos22"));
        userFollowDTOS.add(new UserFollowDTO(6, "mariapaz"));
        userFollowDTOS.add(new UserFollowDTO(1, "pepito1234"));
        List<UserFollowDTO> sortedAsc = userFollowDTOS.stream().sorted(Comparator.comparing(UserFollowDTO::getUserName)).collect(Collectors.toList());
        UserFollowerDTO expected = new UserFollowerDTO(10, "miguelito",
                sortedAsc);
        Mockito.when(userRepository.existingUserById(10)).thenReturn(Boolean.TRUE);
        Mockito.when(userRepository.findById(10)).thenReturn(user);
        Mockito.when(userRepository.findById(1)).thenReturn(user3);
        Mockito.when(userRepository.findById(6)).thenReturn(user2);
        Mockito.when(userRepository.findById(5)).thenReturn(user1);
        Mockito.when(mapper.convertValue(user1, UserFollowDTO.class)).thenReturn(new UserFollowDTO(5, "carlos22"));
        Mockito.when(mapper.convertValue(user2, UserFollowDTO.class)).thenReturn(new UserFollowDTO(6, "mariapaz"));
        Mockito.when(mapper.convertValue(user3, UserFollowDTO.class)).thenReturn(new UserFollowDTO(1, "pepito1234"));
        // act
        UserFollowerDTO actual = userService.getFollowers(user.getUserId(), "name_asc");
        // assert
        Assertions.assertAll(() -> Assertions.assertEquals(expected, actual),
                () -> Assertions.assertEquals(expected.getFollowers().get(0).getUserName(), actual.getFollowers().get(0).getUserName()));
    }

    @Test
    @DisplayName("T004 - Followers ordered correctly DESC - getFollowers")
    void getFollowers_order_desc_Test() {
        //arrange
        User user = new User(10,
                "miguelito",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(1, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        User user1 = new User(5,
                "carlos22",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(2, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        User user2 = new User(6,
                "mariapaz",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(2, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        User user3 = new User(1,
                "pepito1234",
                List.of(5, 6, 1),
                List.of(5, 6, 1),
                List.of(new Post(2, 10, LocalDate.of(2023, 9, 26), new Product(1, "RandomProduct", "type", "brand", "color", "notes"),
                        3,
                        20.0)));
        List<UserFollowDTO> userFollowDTOS = new ArrayList<>();
        userFollowDTOS.add(new UserFollowDTO(1, "pepito1234"));
        userFollowDTOS.add(new UserFollowDTO(5, "carlos22"));
        userFollowDTOS.add(new UserFollowDTO(6, "mariapaz"));
        List<UserFollowDTO> sortedDesc = userFollowDTOS.stream().sorted(Comparator.comparing(UserFollowDTO::getUserName).reversed()).collect(Collectors.toList());
        UserFollowerDTO expected = new UserFollowerDTO(10, "miguelito", sortedDesc);
        Mockito.when(userRepository.existingUserById(10)).thenReturn(Boolean.TRUE);
        Mockito.when(userRepository.findById(10)).thenReturn(user);
        Mockito.when(userRepository.findById(1)).thenReturn(user3);
        Mockito.when(userRepository.findById(6)).thenReturn(user2);
        Mockito.when(userRepository.findById(5)).thenReturn(user1);
        Mockito.when(mapper.convertValue(user1, UserFollowDTO.class)).thenReturn(new UserFollowDTO(5, "carlos22"));
        Mockito.when(mapper.convertValue(user2, UserFollowDTO.class)).thenReturn(new UserFollowDTO(6, "mariapaz"));
        Mockito.when(mapper.convertValue(user3, UserFollowDTO.class)).thenReturn(new UserFollowDTO(1, "pepito1234"));
        // act
        UserFollowerDTO actual = userService.getFollowers(user.getUserId(), "name_desc");
        // assert
        Assertions.assertAll(() -> Assertions.assertEquals(expected, actual),
                () -> Assertions.assertEquals(expected.getFollowers().get(0).getUserName(), actual.getFollowers().get(0).getUserName()));
    }
    @DisplayName("T005 - Valid sorting parameter - getFollowedPostLasTwoWeeksOrd")
    @Test
    void shouldVerifyValidOrderDateExists() {
        // ARRANGE
        when(userRepository.existingUserById(2)).thenReturn(true);
        // ACT
        TwoWeeksPostDTO postTest = userService.getLastTwoWeeksPostByUser(2, "date_asc");
        // ASSERT
        assertNotNull(postTest.getPosts());
    }

    @DisplayName("T005 - Invalid sorting parameter - getFollowedPostLasTwoWeeksOrd")
    @Test
    void shouldCatchValidOrderDateException() {
        // ARRANGE
        when(userRepository.existingUserById(2)).thenReturn(true);
        // ACT & ASSERT
        assertThrows(BadRequestException.class, () -> userService.getLastTwoWeeksPostByUser(2, "invalid_asc"));
    }

    @Test
    @DisplayName("T007 - Validate followers count is correct - getTotalFollowersByUserId")
    void getTotalFollowersByUserId_OkTest() {

        //Arrange
        User user = new User(1, "user1", List.of(2, 3, 4), List.of(), List.of());
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(user);
        int expected = user.getFollowers().size();

        //Act
        int actual = userService.getTotalFollowersByUserId(user.getUserId()).getFollowersCount();

        //Assert
        assertEquals(expected, actual);

    }
}