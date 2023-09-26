package com.meli.be_java_hisp_w22_g01.unitTest;

import com.meli.be_java_hisp_w22_g01.dto.response.FollowMessageDto;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.repository.SellerRepositoryImp;
import com.meli.be_java_hisp_w22_g01.repository.UserRepositoryImp;
import com.meli.be_java_hisp_w22_g01.service.ISellerService;
import com.meli.be_java_hisp_w22_g01.service.SellerServiceImp;
import org.junit.jupiter.api.Assertions;
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
    void setAFollowerBadRequestSellerException(){
        //ARRANGE
        int idFollowerParam = 2;
        int idSellerParam = 2;

        //ACT & ASSERT
        when(sellerRepositoryImp.findById(2)).thenReturn( null);
        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));

    }

    @Test
    void setAFollowerBadRequestUserException(){
        //ARRANGE
        int idFollowerParam = 2;
        int idSellerParam = 2;

        //ACT & ASSERT
        when(userRepositoryImp.findById(2)).thenReturn( null);
        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));

    }

    @Test
    void setAFollowerBadRequestException(){
        // ARRANGE
        int idFollowerParam = 2;
        int idSellerParam = 2;
        Seller seller = new Seller(new ArrayList<>(), new ArrayList<>());
        User user = new User(2, "valen", new ArrayList<>());
        List<User> followers = new ArrayList<>();
        followers.add(user); // Agregar el usuario a la lista de seguidores

        // Configura el objeto simulado sellerRepositoryImp
        Mockito.when(userRepositoryImp.findById(2)).thenReturn(user);
        Mockito.when(sellerRepositoryImp.findById(2)).thenReturn(seller);// Aquí se debe devolver un objeto Seller
        Mockito.when(seller.getFollowers().contains(user)).thenReturn(true);
        // ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class, () -> sellerService.setAFollower(idFollowerParam, idSellerParam));
    }

}
