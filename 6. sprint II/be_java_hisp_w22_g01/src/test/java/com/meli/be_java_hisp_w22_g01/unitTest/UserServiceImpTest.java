package com.meli.be_java_hisp_w22_g01.unitTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowedPostListDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.repository.UserRepositoryImp;
import com.meli.be_java_hisp_w22_g01.service.UserServiceImp;
import com.meli.be_java_hisp_w22_g01.util.UtilTestGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {
    @Mock
    UserRepositoryImp userRepository;

    @Autowired
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
}
