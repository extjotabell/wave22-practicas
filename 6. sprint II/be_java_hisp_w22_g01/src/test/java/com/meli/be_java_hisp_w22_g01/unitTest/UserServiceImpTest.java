package com.meli.be_java_hisp_w22_g01.unitTest;


import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowedDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowedPostListDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowersListDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.repository.SellerRepositoryImp;
import com.meli.be_java_hisp_w22_g01.repository.UserRepositoryImp;
import com.meli.be_java_hisp_w22_g01.service.UserServiceImp;
import com.meli.be_java_hisp_w22_g01.util.UtilTestGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {
    @Mock
    UserRepositoryImp userRepository;

    @Mock
    SellerRepositoryImp sellerRepository;

    @InjectMocks
    UserServiceImp userService;


    @Test
    @DisplayName("T-0003 ✅ - (Asc) Seguidores del vendedor ordenados de forma ascendente")
    public void t0003AscOk() {
        // Arrange

        UserMiniDTO userFollower1 = new UserMiniDTO(1, "Cosme Fulanito");
        UserMiniDTO userFollower2 = new UserMiniDTO(2, "Zadie Smith");
        UserMiniDTO userFollower3 = new UserMiniDTO(3, "Gonzalo");
        List<UserMiniDTO> followed = new ArrayList<>();
        followed.add(userFollower1);
        followed.add(userFollower2);
        followed.add(userFollower3);

        // Seller followed by the user
        Seller seller1 = new Seller();
        seller1.setUser_name("Ahsoka");
        seller1.setUser_id(4);

        List<Seller> sellerFollowed = new ArrayList<>();
        sellerFollowed.add(seller1);

        // Users followers
        User user1 = new User(1, "Cosme Fulanito", sellerFollowed);
        User user2 = new User(2, "Zadie Smith", sellerFollowed);
        User user3 = new User(3, "Gonzalo", sellerFollowed);

        // Followers of the seller
        List<User> sellerFollowers = new ArrayList<>();
        sellerFollowers.add(user1);
        sellerFollowers.add(user2);
        sellerFollowers.add(user3);
        seller1.setFollowers(sellerFollowers);

        UserFollowersListDTO followersDto = new UserFollowersListDTO(4, "Ahsoka", followed);

        when(sellerRepository.findById(4)).thenReturn(seller1);

        // Respuesta esperada
        List<UserMiniDTO> followedExpected = new ArrayList<>();
        followedExpected.add(userFollower1);
        followedExpected.add(userFollower3);
        followedExpected.add(userFollower2);

        UserFollowersListDTO expected = new UserFollowersListDTO(4,"Ahsoka", followedExpected);

        // Act
        UserFollowersListDTO result = userService.orderFollowersDto(4, "name_asc");

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0003 🚫 - (Asc) Seguidores del vendedor ordenados de forma ascendente")
    public void t0003AscFail() {
        Seller seller = new Seller();
        seller.setUser_name("Ahsoka");
        seller.setUser_id(4);

        // Users followers
        List<Seller> sellerFollowed = new ArrayList<>();
        User user1 = new User(1, "Cosme Fulanito", sellerFollowed);
        User user2 = new User(2, "Zadie Smith", sellerFollowed);
        User user3 = new User(3, "Gonzalo", sellerFollowed);

        // Followers of the seller
        List<User> sellerFollowers = new ArrayList<>();
        sellerFollowers.add(user1);
        sellerFollowers.add(user2);
        sellerFollowers.add(user3);
        seller.setFollowers(sellerFollowers);
        // Arrange
        when(sellerRepository.findById(4)).thenReturn(seller);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.orderFollowersDto(4,"hasta_abajo"));
    }

    @DisplayName("T-0005 ✅")
    @Test
    void orderByDateFollowedSellersDateAscOk() {
        // ARRANGE
        String order = "date_asc";
        List<Seller> sellerList = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerList.get(0).getFollowers().get(0);
        when(userRepository.findById(anyInt())).thenReturn(user);

        // ACT
        userService.orderByDateFollowedSellers(1, order);

        // ASSERT
        verify(userRepository, times(1)).findById(user.getUser_id());
    }

    @DisplayName("T-0005 ✅")
    @Test
    void orderByDateFollowedSellersDateDescOk() {
        // ARRANGE
        String order = "date_desc";
        List<Seller> sellerList = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerList.get(0).getFollowers().get(0);
        when(userRepository.findById(anyInt())).thenReturn(user);

        // ACT
        userService.orderByDateFollowedSellers(1, order);

        // ASSERT
        verify(userRepository, times(1)).findById(user.getUser_id());
    }

    @DisplayName("T-0005 🚫")
    @Test
    void orderByDateFollowedSellersDateFail() {
        // ARRANGE
        String order = "sarasa";
        List<Seller> sellerList = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerList.get(0).getFollowers().get(0);

        when(userRepository.findById(anyInt())).thenReturn(user);

        // ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class, () -> userService.orderByDateFollowedSellers(1, order));
    }

    @Test
    @DisplayName("Verificamos que la fecha esta ordenada ascendente")
    void orderByDateFollowedSellersDateASC(){
        //ARRANGE
        int userIdParam = 4;
        String order = "date_asc";
        List<Seller> sellerWithPosts = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerWithPosts.get(1).getFollowers().get(0);

        Mockito.when(userRepository.findById(4)).thenReturn(user);
        UserFollowedPostListDTO lista = userService.userFollowedPostList(userIdParam);
        List<LocalDate> fechas = lista.getPosts().stream()
                .map(PostDto::getDate).toList();

        List<LocalDate> expected = fechas.stream()
                .sorted()
                .collect(Collectors.toList());


        //ACT

        UserFollowedPostListDTO obtained = userService.orderByDateFollowedSellers(userIdParam,order);
        List<LocalDate> obtainedDates = obtained.getPosts().stream().map(PostDto::getDate).toList();

        //ASSERT

        Assertions.assertEquals(expected,obtainedDates);

        System.out.print("expected " + expected + "\n" + "obtained " + obtainedDates);

    }

    @Test
    @DisplayName("Verificamos que la fecha este ordenada descendiente")
    void orderByDateFollowedSellersDateDES(){
        //ARRANGE
        int userIdParam = 4;
        String order = "date_desc";
        List<Seller> sellerWithPosts = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerWithPosts.get(1).getFollowers().get(0);

        Mockito.when(userRepository.findById(4)).thenReturn(user);

        UserFollowedPostListDTO lista = userService.userFollowedPostList(userIdParam);
        List<LocalDate> fechas = lista.getPosts().stream()
                .map(PostDto::getDate).toList();

        List<LocalDate> expected = fechas.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        //ACT

        UserFollowedPostListDTO obtained = userService.orderByDateFollowedSellers(userIdParam,order);
        List<LocalDate> obtainedDates = obtained.getPosts().stream().map(PostDto::getDate).toList();

        //ASSERT

        Assertions.assertEquals(expected,obtainedDates);
        System.out.print("expected " + expected + "\n" + "obtained " + obtainedDates);

    }

    @Test
    @DisplayName(value = "OK: Verifica que el orden asc/desc pedido funcione en followed.")
    void orderFollowsDtoByNameAscDescTest() {
        // ARRANGE
        String order = "name_asc";
        String order2 = "name_desc";
        Seller seller = UtilTestGenerator.get2SellerWithPosts().get(0);
        User mockUser = seller.getFollowers().get(0);
        List<UserMiniDTO> orderedList = Arrays.asList(new UserMiniDTO(4, "Berna"),
                new UserMiniDTO(5, "Carla"));

        when(userRepository.findById(anyInt())).thenReturn(mockUser);

        //ACT
        FollowedDTO result = userService.orderFollowedDto(mockUser.getUser_id(), order);
        FollowedDTO result2 = userService.orderFollowedDto(mockUser.getUser_id(), order2);

        //ASSERT
        assertEquals(orderedList, result.getFollowed());
        reverse(orderedList);
        assertEquals(orderedList, result2.getFollowed());
    }
    @Test
    @DisplayName(value = "OK: Verifica que el orden asc/desc pedido funcione en followers.")
    void orderFollowersDtoByNameAscDescTest() {
        // ARRANGE
        String order = "name_asc";
        String order2 = "name_desc";
        Seller mockSeller = UtilTestGenerator.get2SellerWithPosts().get(1);
        List<UserMiniDTO> orderedList = Arrays.asList(new UserMiniDTO(2, "Alberto"),
                new UserMiniDTO(3, "Dario"), new UserMiniDTO(1, "Pepe"));

        List<UserMiniDTO> orderedDescList = Arrays.asList(new UserMiniDTO(1, "Pepe"),
                new UserMiniDTO(3, "Dario"), new UserMiniDTO(2, "Alberto"));

        when(sellerRepository.findById(anyInt())).thenReturn(mockSeller);

        //ACT
        UserFollowersListDTO result = userService.orderFollowersDto(mockSeller.getUser_id(), order);
        UserFollowersListDTO result2 = userService.orderFollowersDto(mockSeller.getUser_id(), order2);

        //ASSERT
        assertEquals(orderedList, result.getFollowers());
        assertEquals(orderedDescList, result2.getFollowers());
    }
    @Test
    @DisplayName(value = "FAIL: El orden proporcionado no existe para followed")
    void orderFollowedDtoBadRequestException() {
        // ARRANGE
        String orderFake = "name_fake";
        Seller seller = UtilTestGenerator.get2SellerWithPosts().get(1);
        User user = seller.getFollowers().get(0);
        when(userRepository.findById(anyInt())).thenReturn(user);

        //ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class,()-> userService.orderFollowedDto(user.getUser_id(), orderFake));
    }
    @Test
    @DisplayName(value = "FAIL: El orden proporcionado no existe para followers")
    void orderFollowersDtoBadRequestException() {
        // ARRANGE
        String orderFake = "name_fake";
        Seller mockSeller = UtilTestGenerator.get2SellerWithPosts().get(1);
        when(sellerRepository.findById(anyInt())).thenReturn(mockSeller);

        //ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class,()-> userService.orderFollowersDto(mockSeller.getUser_id(), orderFake));
    }

    @DisplayName("T-0008 ✅")
    @Test
    void userFollowedPostListOk() {
        // ARRANGE
        List<Seller> sellerWithPosts = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerWithPosts.get(0).getFollowers().get(0);
        List<PostDto> postsDTO = UtilTestGenerator.get4PostsDTO();

        when(userRepository.findById(anyInt())).thenReturn(user);

        UserFollowedPostListDTO expected = new UserFollowedPostListDTO(1, List.of(postsDTO.get(0), postsDTO.get(1), postsDTO.get(2)));

        // ACT
        UserFollowedPostListDTO result = userService.userFollowedPostList(user.getUser_id());

        // ASSERT
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("T-0008 ✅")
    @Test
    void userFollowedPostListOk2() {
        // ARRANGE
        List<Seller> sellerWithPosts = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerWithPosts.get(1).getFollowers().get(0);
        List<PostDto> postsDTO = UtilTestGenerator.get4PostsDTO();

        when(userRepository.findById(anyInt())).thenReturn(user);

        UserFollowedPostListDTO expected = new UserFollowedPostListDTO(2, List.of(postsDTO.get(2)));

        // ACT
        UserFollowedPostListDTO result = userService.userFollowedPostList(user.getUser_id());

        // ASSERT
        Assertions.assertEquals(expected, result);
    }
}
