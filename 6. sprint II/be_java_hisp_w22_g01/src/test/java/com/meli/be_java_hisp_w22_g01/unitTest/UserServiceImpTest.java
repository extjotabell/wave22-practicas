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
import java.util.List;

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
    @DisplayName("T-0003 ✅: Verifica el ordenamiento mediante name_asc y name_desc")
    void t0003Ok() {
        // ARRANGE

        String order1 = "name_asc";
        String order2 = "name_desc";

        UserMiniDTO userFollower1 = new UserMiniDTO(1, "Cosme Fulanito");
        UserMiniDTO userFollower2 = new UserMiniDTO(2, "Zadie Smith");
        UserMiniDTO userFollower3 = new UserMiniDTO(3, "Gonzalo");

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

        when(sellerRepository.findById(4)).thenReturn(seller1);

        // Respuesta esperada
        List<UserMiniDTO> followedExpected = new ArrayList<>();
        followedExpected.add(userFollower1);
        followedExpected.add(userFollower3);
        followedExpected.add(userFollower2);

        UserFollowersListDTO expected = new UserFollowersListDTO(4,"Ahsoka", followedExpected);

        // ACT
        UserFollowersListDTO result_asc = userService.orderFollowersDto(4, order1);
        UserFollowersListDTO result_desc = userService.orderFollowersDto(4, order2);

        // ASSERT
        assertEquals(expected, result_asc);
        reverse(followedExpected);
        assertEquals(expected, result_desc);
    }

    @Test
    @DisplayName("T-0003 🚫: Verificar la no existencia de un método de ordenamiento no contemplado")
    void t0003Fail() {
        // ARRANGE
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

        when(sellerRepository.findById(4)).thenReturn(seller);

        // ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class, () -> userService.orderFollowersDto(4,"hasta_abajo"));
    }

    @Test
    @DisplayName("T-0004 ✅: Verifica que el orden ascendente pedido funcione en followed.")
    void t0004Ok() {
        // ARRANGE
        String order = "name_asc";
        Seller seller = UtilTestGenerator.get2SellerWithPosts().get(0);
        User mockUser = seller.getFollowers().get(0);
        List<UserMiniDTO> orderedList = Arrays.asList(new UserMiniDTO(4, "Berna"),
                new UserMiniDTO(5, "Carla"));

        when(userRepository.findById(anyInt())).thenReturn(mockUser);

        //ACT
        FollowedDTO result = userService.orderFollowedDto(mockUser.getUser_id(), order);

        //ASSERT
        assertEquals(orderedList, result.getFollowed());
    }

    @Test
    @DisplayName("T-0004 ✅: Verifica que el orden descendente pedido funcione en followed.")
    void t0004Ok2() {
        // ARRANGE
        String order2 = "name_desc";
        Seller seller = UtilTestGenerator.get2SellerWithPosts().get(0);
        User mockUser = seller.getFollowers().get(0);
        List<UserMiniDTO> orderedList = Arrays.asList(new UserMiniDTO(4, "Berna"),
                new UserMiniDTO(5, "Carla"));

        when(userRepository.findById(anyInt())).thenReturn(mockUser);

        //ACT
        FollowedDTO result2 = userService.orderFollowedDto(mockUser.getUser_id(), order2);

        //ASSERT
        reverse(orderedList);
        assertEquals(orderedList, result2.getFollowed());
    }
    @Test
    @DisplayName("T-0004 ✅: Verifica que el orden ascendente pedido funcione en followers.")
    void t0004Ok3() {
        // ARRANGE
        String order = "name_asc";
        Seller mockSeller = UtilTestGenerator.get2SellerWithPosts().get(1);
        List<UserMiniDTO> orderedList = Arrays.asList(new UserMiniDTO(2, "Alberto"),
                new UserMiniDTO(3, "Dario"), new UserMiniDTO(1, "Pepe"));

        when(sellerRepository.findById(anyInt())).thenReturn(mockSeller);

        //ACT
        UserFollowersListDTO result = userService.orderFollowersDto(mockSeller.getUser_id(), order);

        //ASSERT
        assertEquals(orderedList, result.getFollowers());
    }
    @Test
    @DisplayName("T-0004 ✅: Verifica que el orden descendente pedido funcione en followers.")
    void t0004Ok4() {
        // ARRANGE
        String order2 = "name_desc";
        Seller mockSeller = UtilTestGenerator.get2SellerWithPosts().get(1);
        List<UserMiniDTO> orderedDescList = Arrays.asList(new UserMiniDTO(1, "Pepe"),
                new UserMiniDTO(3, "Dario"), new UserMiniDTO(2, "Alberto"));

        when(sellerRepository.findById(anyInt())).thenReturn(mockSeller);

        //ACT
        UserFollowersListDTO result2 = userService.orderFollowersDto(mockSeller.getUser_id(), order2);

        //ASSERT
        assertEquals(orderedDescList, result2.getFollowers());
    }

    @Test
    @DisplayName("T-0004 🚫: El orden proporcionado no existe para followed")
    void t0004Fail() {
        // ARRANGE
        String orderFake = "name_fake";
        Seller seller = UtilTestGenerator.get2SellerWithPosts().get(1);
        User user = seller.getFollowers().get(0);
        when(userRepository.findById(anyInt())).thenReturn(user);

        //ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class,()-> userService.orderFollowedDto(1, orderFake));
    }
    @Test
    @DisplayName("T-0004 🚫: El orden proporcionado no existe para followers")
    void t0004Fail2() {
        // ARRANGE
        String orderFake = "name_fake";
        Seller mockSeller = UtilTestGenerator.get2SellerWithPosts().get(1);
        when(sellerRepository.findById(anyInt())).thenReturn(mockSeller);

        //ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class,()-> userService.orderFollowersDto(1, orderFake));
    }

    @DisplayName("T-0005 ✅: Verificar que el tipo de ordenamiento por fecha ascendente exista")
    @Test
    void t0005Ok() {
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

    @DisplayName("T-0005 ✅: Verificar que el tipo de ordenamiento por fecha descendente exista")
    @Test
    void t0005Ok2() {
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

    @DisplayName("T-0005 🚫: Verificar la no existencia de un método de ordenamiento no contemplado")
    @Test
    void t0005Fail() {
        // ARRANGE
        String order = "name_fake";
        List<Seller> sellerList = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerList.get(0).getFollowers().get(0);

        when(userRepository.findById(anyInt())).thenReturn(user);

        // ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class, () -> userService.orderByDateFollowedSellers(1, order));
    }

    @Test
    @DisplayName("T-0006 ✅: Verificamos que la fecha esta ordenada ascendente")
    void t0006Ok(){
        //ARRANGE
        int userIdParam = 4;
        String order = "date_asc";
        List<Seller> sellerWithPosts = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerWithPosts.get(0).getFollowers().get(0);

        Mockito.when(userRepository.findById(4)).thenReturn(user);
        List<LocalDate> expected = List.of(LocalDate.now().minusDays(3), LocalDate.now(), LocalDate.now());

        //ACT
        UserFollowedPostListDTO obtained = userService.orderByDateFollowedSellers(userIdParam,order);
        List<LocalDate> obtainedDates = obtained.getPosts().stream().map(PostDto::getDate).toList();

        //ASSERT
        Assertions.assertEquals(expected,obtainedDates);
    }

    @Test
    @DisplayName("T-0006 ✅: Verificamos que la fecha este ordenada descendiente")
    void t0006Ok2(){
        //ARRANGE
        String order = "date_desc";
        List<Seller> sellerWithPosts = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerWithPosts.get(0).getFollowers().get(0);

        Mockito.when(userRepository.findById(anyInt())).thenReturn(user);

        List<LocalDate> expected = List.of(LocalDate.now(), LocalDate.now(), LocalDate.now().minusDays(3));

        //ACT
        UserFollowedPostListDTO obtained = userService.orderByDateFollowedSellers(user.getUser_id(), order);
        List<LocalDate> obtainedDates = obtained.getPosts().stream().map(PostDto::getDate).toList();

        //ASSERT
        Assertions.assertEquals(expected,obtainedDates);
    }

    @Test
    @DisplayName("T-0008 ✅: Verificar que la consulta de publicaciones realizadas en la últimas 2 semanas de un determinado vendedor sean efectivamente de las últimas 2 semanas")
    void t0008Ok() {
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

    @Test
    @DisplayName("T-0008 ✅: Verificar que la consulta de publicaciones realizadas en la últimas 2 semanas de un determinado vendedor sean efectivamente de las últimas 2 semanas")
    void t0008Ok2() {
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
