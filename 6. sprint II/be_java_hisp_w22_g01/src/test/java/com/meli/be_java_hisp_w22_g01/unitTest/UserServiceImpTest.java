package com.meli.be_java_hisp_w22_g01.unitTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowedPostListDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.repository.UserRepositoryImp;
import com.meli.be_java_hisp_w22_g01.service.UserServiceImp;
import com.meli.be_java_hisp_w22_g01.util.UtilTestGenerator;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {
    @Mock
    UserRepositoryImp userRepository;
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
        verify(userService, times(1)).orderByDateFollowedSellers(1, order);
    }

    @Test
    void orderByDateFollowedSellersDateDescOk() {
        // ARRANGE
        String order = "date_desc";
        List<Seller> sellerList = UtilTestGenerator.get2SellerWithPosts();
        User user = sellerList.get(0).getFollowers().get(0);
        when(userRepository.findById(anyInt())).thenReturn(user);
        UserFollowedPostListDTO userFollowedPostListDTO = UtilTestGenerator.getUserFollowedPostListDTO();
        when(userService.userFollowedPostList(anyInt())).thenReturn(userFollowedPostListDTO);

        // ACT
        userService.orderByDateFollowedSellers(1, order);

        // ASSERT
        verify(userService, times(1)).orderByDateFollowedSellers(1, order);
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
        System.out.print("expected " + expected + "\n");
        System.out.print("obtained " + obtainedDates);

    }

    @Test
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
        System.out.print("expected " + expected + "\n");
        System.out.print("obtained " + obtainedDates);

    }

}
