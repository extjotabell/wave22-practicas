package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;

import com.example.be_java_hisp_w22_g05.entity.User;

import com.example.be_java_hisp_w22_g05.dto.UserFollowersDto;
import com.example.be_java_hisp_w22_g05.exception.FollowException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;

import com.example.be_java_hisp_w22_g05.repository.UserRepository;
import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static com.example.be_java_hisp_w22_g05.utils.UserGenerator.getUserWithNameId;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Nested
    class TS0004{
        @Test
        @DisplayName("Orden ascendente OK")
        void findUsersFollowingSellerAscTest(){
            //Arrange
            String expected = "Juan";
            User user1 = new User(24, "Maria", new ArrayList<>(), new ArrayList<>());
            User user2 = new User(21, "Juan", new ArrayList<>(), new ArrayList<>());
            List<User> followers = new ArrayList<>();
            followers.add(user1);
            followers.add(user2);
            User userResponseMock = new User(1,"Enzo",followers,new ArrayList<>());
            Mockito.when(userRepository.findUsersById(1)).thenReturn(userResponseMock);

            //Act
            UserFollowersDto obtain = userService.findUsersFollowingSeller(1,"name_asc");

            //Assert
            Assertions.assertEquals(expected, obtain.getFollowers().get(0).getName());
        }

        @Test
        @DisplayName("Orden descendente OK")
        void findUsersFollowingSellerDescTest(){
            //Arrange
            String expected = "Maria";
            User user1 = new User(24, "Juan", new ArrayList<>(), new ArrayList<>());
            User user2 = new User(21, "Maria", new ArrayList<>(), new ArrayList<>());
            List<User> followers = new ArrayList<>();
            followers.add(user1);
            followers.add(user2);
            User userResponseMock = new User(1,"Enzo",followers,new ArrayList<>());
            Mockito.when(userRepository.findUsersById(1)).thenReturn(userResponseMock);

            //Act
            UserFollowersDto obtain = userService.findUsersFollowingSeller(1,"name_desc");

            //Assert
            Assertions.assertEquals(expected, obtain.getFollowers().get(0).getName());

        }
    }


    @Nested
    class TS0001{
        @Test
        @DisplayName("Follow OK")
        void followUserOk() {
            //Arrange
            User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
            User userToFollow = new User(2, "maria", new ArrayList<>(), new ArrayList<>());

            //Usuario que debe quedar luego de hacer el follow (tiene un item en la lista de followed)
            User userAfterFollow = new User(1, "carlos", new ArrayList<>(), List.of(userToFollow));

            UserFollowedDto expected = new UserFollowedDto(userAfterFollow.getId(), userAfterFollow.getName(), userAfterFollow.getFollowed().stream()
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
        @DisplayName("Follow User NotFound")
        void followNonExistingUser(){
            //Arrange
            User user = new User(1,"carlos",new ArrayList<>(),new ArrayList<>());
            int userIdToFollow = 0;

            when(userRepository.findUsersById(user.getId())).thenReturn(user);
            when(userRepository.findUsersById(0)).thenReturn(null);

            //Act & Assert
            Assertions.assertThrows(NotFoundException.class, ()-> userService.followUser(user.getId(), userIdToFollow));
        }
    }


    @Nested
    class TS0002{
        @Test
        @DisplayName("Unfollow OK")
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
        @DisplayName("Unfollow User NotFound")
        void unfollowUserNotFound() {
            //Arrange
            User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
            int userIdToUnfollow = 2;

            UserFollowedDto expected = new UserFollowedDto(user.getId(), user.getName(),
                    user.getFollowed().stream().map(u -> new UserDto(u.getId(), u.getName())).collect(Collectors.toList()));

            when(userRepository.findUsersById(user.getId())).thenReturn(user);
            when(userRepository.findUsersById(userIdToUnfollow)).thenReturn(null);

            //Act & Assert
            Assertions.assertThrows(NotFoundException.class, () -> userService.unfollowUser(user.getId(), userIdToUnfollow));
        }
    }

    @Nested
    class TS0003{
        @Test
        @DisplayName("Existe el ordenamiento descendente.")
        void existOrderNameDescOk(){
            //ARRANGE
            UserFollowersDto expected = new UserFollowersDto(1,"Carlos", List.of(new UserDto(2,"Maria")));
            String order = "name_desc";
            User expectedRepository = new User(1,"Carlos",List.of(new User(2,"Maria", List.of(), List.of())),List.of());
            when(userRepository.findUsersById(1)).thenReturn(expectedRepository);

            //ACT
            UserFollowersDto actual = userService.findUsersFollowingSeller(1,order);

            //ASSERTION
            Assertions.assertEquals(expected.getFollowers(),actual.getFollowers());

        }

        @Test
        @DisplayName("Ordenamiento NotFound")
        void existOrderNotFound(){
            //ARRANGE
            String order = "fake";
            User expectedRepository = new User(1,"Carlos",List.of(new User(2,"Maria", List.of(), List.of())),List.of());
            when(userRepository.findUsersById(1)).thenReturn(expectedRepository);

            //ACT AND ASSERTION
            Assertions.assertThrows(NotFoundException.class,() -> userService.findUsersFollowingSeller(1,order));

        }

        @Test
        @DisplayName("Existe el ordenamiento ascendente")
        void existOrderNameAscOk(){
            //ARRANGE
            UserFollowersDto expected = new UserFollowersDto(1,"Carlos", List.of(new UserDto(2,"Maria")));
            String order = "name_asc";
            User expectedRepository = new User(1,"Carlos",List.of(new User(2,"Maria", List.of(), List.of())),List.of());
            when(userRepository.findUsersById(1)).thenReturn(expectedRepository);

            //ACT
            UserFollowersDto actual = userService.findUsersFollowingSeller(1,order);

            //ASSERTION
            Assertions.assertEquals(expected.getFollowers(),actual.getFollowers());

        }
    }

    @Nested
    class TS0007{
        @Test
        @DisplayName("Cantidad de seguidores OK")
        void followersOfUser(){
            // ARRANGE
            User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
            User userFollower =  new User(2, "maria", new ArrayList<>(), new ArrayList<>());
            user.getFollower().add(userFollower);
            UserNumberFollowersDto expected = new UserNumberFollowersDto(user.getId(), user.getName(), user.getFollower().size());
            when (userRepository.findUsersById(user.getId())).thenReturn(user);

            // ACT
            UserNumberFollowersDto result = userService.getNumberFollowers(user.getId());

            // ASSERT
            Assertions.assertEquals(expected.getFollowersCount(), result.getFollowersCount());
        }
    }

    //Aqui realize otros unit test no requeridos para aumentar el coverage
    @Nested
    class testsParteIndividual{

        //Follow Units Tests
        @Nested
        class Follow{
            @Test
            @DisplayName("Already follow Error")
            void alreadyFollow(){
                //Arrange
                User follower = getUserWithNameId(1,"Enzo");
                User seller = getUserWithNameId(2,"Mati");
                follower.getFollowed().add(seller);
                when(userRepository.findUsersById(1)).thenReturn(follower);
                when(userRepository.findUsersById(2)).thenReturn(seller);

                //Act & Assert
                Assertions.assertThrows(FollowException.class, ()-> userService.followUser(follower.getId(), seller.getId()));
            }
        }

        //Number Followers Units Test
        @Nested
        class NumberFollowers{
            @Test
            @DisplayName("User Number Followers Not Found")
            void UserNumberFollowersNotFound(){
                //Arrange
                when(userRepository.findUsersById(1)).thenReturn(null);

                //Act & Assert
                Assertions.assertThrows(NotFoundException.class, ()-> userService.getNumberFollowers(1));
            }
        }


        //ListOfUsersFollowed Units Tests
        @Nested
        class ListOfUsersFollowed{
            @Test
            @DisplayName("List Of Users Followed Not Found")
            void ListOfUsersFollowedNotFound(){
                //Arrange
                when(userRepository.findUsersById(1)).thenReturn(null);

                //Act & Assert
                Assertions.assertThrows(NotFoundException.class, ()-> userService.getListOfUsersFollowedBy(1, ""));
            }

            @Test
            @DisplayName("List Of Users Followed Ok")
            void getListOfUsersFollowedByOkTest(){
                //Arrange
                String expected = "Mati";
                User follower = getUserWithNameId(1,"Enzo");
                User seller = getUserWithNameId(2,"Mati");
                follower.getFollowed().add(seller);
                when(userRepository.findUsersById(1)).thenReturn(follower);

                //Act
                UserFollowedDto obtain = userService.getListOfUsersFollowedBy(1, null);

                //Assert
                Assertions.assertEquals(expected,obtain.getFollowed().get(0).getName());
            }
        }

        //Unfollow Units Tests
        @Nested
        class Unfollow{
            @Test
            @DisplayName("Unfollowed Not Found")
            void unfollowedNotFound(){
                //Arrange
                User follower = getUserWithNameId(1,"Enzo");
                User seller = getUserWithNameId(2,"Mati");
                when(userRepository.findUsersById(1)).thenReturn(follower);
                when(userRepository.findUsersById(2)).thenReturn(seller);

                //Act & Assert
                Assertions.assertThrows(NotFoundException.class, ()-> userService.unfollowUser(follower.getId(), seller.getId()));
            }
        }
    }
}
