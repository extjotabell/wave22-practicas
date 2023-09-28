package com.meli.be_java_hisp_w22_g01.unitTest;

import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.*;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
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
    @DisplayName("T-0002 ✅: Verificar que el usuario a dejar de seguir exista.")
    void t0002Ok(){

        // ARRANGE
        int param_userId = 1;
        int param_userIdToUnfollow = 4;
        MessageDTO message_expected = new MessageDTO("El usuario userId: " + param_userId + " ha dejado de seguir a userId: " + param_userIdToUnfollow);

        when(userRepository.getAll()).thenReturn(UtilTestGenerator.get3UserWithFollowers());

        // ACT
        MessageDTO message_unfollow = userService.unfollow(param_userId, param_userIdToUnfollow);

        // ASSERT
        Assertions.assertEquals(message_expected, message_unfollow);

    }

    @Test
    @DisplayName("T-0002 🚫: Error, usuario no sigue al vendedor.")
    void t0002Fail(){

        // ARRANGE
        int param_userId = 1;
        int param_userIdToUnfollow = 7;
        when(userRepository.getAll()).thenReturn(UtilTestGenerator.get3UserWithFollowers());

        // ACT & ASSERT
        Assertions.assertThrows(NotFoundException.class, () -> userService.unfollow(param_userId, param_userIdToUnfollow));
    }

    @Test
    @DisplayName("T-0002 🚫: Error, usuario no encontrado")
    void t0002Fail2(){

        // ARRANGE
        int param_userId = 9;
        int param_userIdToUnfollow = 2;
        when(userRepository.getAll()).thenReturn(UtilTestGenerator.get3UserWithFollowers());

        // ACT & ASSERT
        Assertions.assertThrows(NotFoundException.class, () -> userService.unfollow(param_userId, param_userIdToUnfollow));
    }

    @Test
    @DisplayName("T-0003 ✅: Verifica la existencia de ordenamiento mediante name_asc")
    void t0003Ok() {
        // ARRANGE
        String order1 = "name_asc";
        when(sellerRepository.findById(4)).thenReturn(new Seller(List.of(), List.of()));

        // ACT
        userService.orderFollowersDto(4, order1);

        // ASSERT
        verify(sellerRepository, times(1)).findById(4);
    }

    @Test
    @DisplayName("T-0003 ✅: Verifica el ordenamiento mediante name_desc")
    void t0003Ok2() {
        // ARRANGE
        String order1 = "name_desc";
        when(sellerRepository.findById(4)).thenReturn(new Seller(List.of(), List.of()));

        // ACT
        userService.orderFollowersDto(4, order1);

        // ASSERT
        verify(sellerRepository, times(1)).findById(4);
    }

    @Test
    @DisplayName("T-0003 🚫: Verificar la no existencia de un método de ordenamiento no contemplado")
    void t0003Fail() {
        // ARRANGE
        when(sellerRepository.findById(4)).thenReturn(new Seller(List.of(), List.of()));

        // ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class, () -> userService.orderFollowersDto(4,"name_fake"));
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
        List<LocalDate> obtainedDates = obtained.getPosts().stream().map(PostDTO::getDate).toList();

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
        List<LocalDate> obtainedDates = obtained.getPosts().stream().map(PostDTO::getDate).toList();

        //ASSERT
        Assertions.assertEquals(expected,obtainedDates);
    }

    @Test
    @DisplayName("T-0008 ✅: Verificar que la consulta de publicaciones realizadas en la últimas 2 semanas de un determinado vendedor sean efectivamente de las últimas 2 semanas")
    void t0008Ok() {
        // ARRANGE
        List<Seller> sellerWithPosts = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerWithPosts.get(0).getFollowers().get(0);
        List<PostDTO> postsDTO = UtilTestGenerator.get4PostsDTO();

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
        List<PostDTO> postsDTO = UtilTestGenerator.get4PostsDTO();

        when(userRepository.findById(anyInt())).thenReturn(user);

        UserFollowedPostListDTO expected = new UserFollowedPostListDTO(2, List.of(postsDTO.get(2)));

        // ACT
        UserFollowedPostListDTO result = userService.userFollowedPostList(user.getUser_id());

        // ASSERT
        Assertions.assertEquals(expected, result);
    }
}
