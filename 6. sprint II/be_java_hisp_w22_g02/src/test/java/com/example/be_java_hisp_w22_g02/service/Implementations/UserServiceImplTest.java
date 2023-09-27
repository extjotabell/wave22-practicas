package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowerDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Product;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;
    @Mock
    ObjectMapper mapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void followUser() {
    }

    @Test
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

    @Test
    void getTotalFollowersByUserId() {
    }

    @Test
    void unfollowUser() {
    }

    @Test
    void getFollowed() {
    }

    @Test
    void addUserPost() {
    }

    @Test
    void getLastTwoWeeksPostByUser() {
    }
}