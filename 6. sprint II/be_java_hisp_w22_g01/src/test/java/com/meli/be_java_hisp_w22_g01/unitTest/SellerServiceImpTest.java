package com.meli.be_java_hisp_w22_g01.unitTest;

import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowMessageDto;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.repository.SellerRepositoryImp;
import com.meli.be_java_hisp_w22_g01.repository.UserRepositoryImp;
import com.meli.be_java_hisp_w22_g01.service.SellerServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SellerServiceImpTest {

    @Mock
    SellerRepositoryImp sellerRepositoryImp;
    @Mock
    UserRepositoryImp userRepositoryImp;

    @InjectMocks
    SellerServiceImp sellerService;

    @Test
    @DisplayName(value = "T-0001 OK: Verificar que el usuario a seguir exista")
    void setAFollowerOk(){
        //ARRANGE
        int idFollowerParam = 1;
        int idSellerParam = 1;
        FollowMessageDto expected = new FollowMessageDto("El user: " + idFollowerParam + " comenzo a seguir a: " + idSellerParam);

        //ACT
        when(userRepositoryImp.findById(1)).thenReturn(new User(1, "belu", new ArrayList<>()));
        when(sellerRepositoryImp.findById(1)).thenReturn(new Seller(new ArrayList<>(),new ArrayList<>()));
        FollowMessageDto result = sellerService.setAFollower(idFollowerParam,idSellerParam);

        //ASSERT
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName(value = "T-0001 FAIL: No se encontró el seller")
    void setAFollowerBadRequestSellerException(){
        //ARRANGE
        int idFollowerParam = 2;
        int idSellerParam = 2;

        //ACT & ASSERT
        when(sellerRepositoryImp.findById(2)).thenReturn( null);
        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));

    }

    @Test
    @DisplayName(value = "T-0001 FAIL: El usuario proporcionado no existe")
    void setAFollowerBadRequestUserException(){
        //ARRANGE
        int idFollowerParam = 2;
        int idSellerParam = 2;

        //ACT & ASSERT
        when(userRepositoryImp.findById(2)).thenReturn( null);
        when(sellerRepositoryImp.findById(2)).thenReturn( new Seller());
        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));

    }

    @DisplayName(value = "T-0001 FAIL: Ya es seguidor de ese seller")
    void setAFollowerBadRequestException(){
        //ARRANGE
        int idFollowerParam = 1;
        int idSellerParam = 2;
        User user = new User(1,"belu",new ArrayList<>());
        Seller seller = new Seller(new ArrayList<>(), List.of(user));

        //ACT & ASSERT
        when(userRepositoryImp.findById(1)).thenReturn(user);
        when(sellerRepositoryImp.findById(2)).thenReturn( seller);

        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));
    }


    @Test
    @DisplayName(value = "T-0002 - Resultado correcto")
    void countFollowers(){
        //ARRANGE
        int user = 1;
        String user_name_param = "Rick Harrison";
        CountFollowersDTO param_result = new CountFollowersDTO(1,user_name_param,1);

        // ACT
        User user_test = new User(user,"Elon Musk",new ArrayList<>());
        Seller seller_test = new Seller(new ArrayList<>(), List.of(user_test));
        seller_test.setUser_id(user);
        seller_test.setUser_name(user_name_param);

        when(sellerRepositoryImp.findById(1)).thenReturn(seller_test);
        CountFollowersDTO test_result = sellerService.countFollowers(user);

        // ASSERT
        Assertions.assertEquals(param_result, test_result);
    }
}
