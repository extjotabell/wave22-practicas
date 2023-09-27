package com.meli.be_java_hisp_w22_g01.unitTest;

import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowMessageDto;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
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

<<<<<<< Updated upstream

    @Test
    @DisplayName(value = "T-0002 - Usuario inexistente")
    void countFollowersErrorUserNoExists(){

        //ARRANGE
        int user = 1;

        // ACT
        when(sellerRepositoryImp.findById(1)).thenReturn(null);

        // ASSERT
        Assertions.assertThrows(NotFoundException.class, () -> sellerService.countFollowers(user));
    }

=======
    @Test
    @DisplayName("T0007 ✅ - Verificar que la cantidad de seguidores de un determinado usuario se correcta") //US 0002
    public void t0007Ok(){
        // Arrange

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

        when(sellerRepositoryImp.findById(4)).thenReturn(seller1);

        // expected
        CountFollowersDTO expected = new CountFollowersDTO(4, "Ahsoka", 3);

        // Act
        CountFollowersDTO result = sellerService.countFollowers(4);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0007 🚫 - Verificar que la cantidad de seguidores de un determinado usuario se correcta")
    public void t0007Fail(){
        // Arrange
//        Seller seller = null;
        when(sellerRepositoryImp.findById(4)).thenReturn(null);

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> sellerService.countFollowers(4));
    }
>>>>>>> Stashed changes
}
