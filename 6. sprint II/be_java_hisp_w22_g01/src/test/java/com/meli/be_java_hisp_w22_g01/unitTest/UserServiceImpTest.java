package com.meli.be_java_hisp_w22_g01.unitTest;


import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowedDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowedPostListDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowersListDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {
    @Mock
    UserRepositoryImp userRepository;
    @Mock
    ObjectMapper mapper;

    @InjectMocks
    UserServiceImp userService;


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
        FollowedDTO result = userService.orderFollowsDto(mockUser.getUser_id(), order);
        FollowedDTO result2 = userService.orderFollowsDto(mockUser.getUser_id(), order2);

        //ASSERT
        assertEquals(orderedList, result.getFollowed());
        reverse(orderedList);
        assertEquals(orderedList, result2.getFollowed());
    }



}
