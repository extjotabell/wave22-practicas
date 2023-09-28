package com.meli.be_java_hisp_w22_g01.unitTest;

import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.MessageDTO;
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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SellerServiceImpTest {

    @Mock
    SellerRepositoryImp sellerRepositoryImp;
    @Mock
    UserRepositoryImp userRepositoryImp;

    @InjectMocks
    SellerServiceImp sellerService;

    @Test
    @DisplayName("T-0001 ✅: Verificar que el usuario a seguir exista")
    void t0001Ok(){
        //ARRANGE
        int idFollowerParam = 1;
        int idSellerParam = 1;
        MessageDTO expected = new MessageDTO("El user: " + idFollowerParam + " comenzo a seguir a: " + idSellerParam);
        when(userRepositoryImp.findById(1)).thenReturn(new User(1, "belu", new ArrayList<>()));
        when(sellerRepositoryImp.findById(1)).thenReturn(new Seller(new ArrayList<>(),new ArrayList<>()));

        //ACT
        MessageDTO result = sellerService.setAFollower(idFollowerParam,idSellerParam);

        //ASSERT
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("T-0001 🚫: No se encontró el seller")
    void t0001Fail(){
        //ARRANGE
        int idFollowerParam = 2;
        int idSellerParam = 2;
        when(sellerRepositoryImp.findById(2)).thenReturn( null);

        //ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));
    }

    @Test
    @DisplayName("T-0001 🚫: El usuario proporcionado no existe")
    void t0001Fail2(){
        //ARRANGE
        int idFollowerParam = 2;
        int idSellerParam = 2;
        when(userRepositoryImp.findById(2)).thenReturn( null);
        when(sellerRepositoryImp.findById(2)).thenReturn( new Seller());

        //ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));
    }

    @Test
    @DisplayName("T-0001 🚫: Ya es seguidor de ese seller")
    void t0001Fail3(){
        //ARRANGE
        int idFollowerParam = 1;
        int idSellerParam = 2;
        User user = new User(1,"belu",new ArrayList<>());
        Seller seller = new Seller(new ArrayList<>(), List.of(user));
        when(userRepositoryImp.findById(1)).thenReturn(user);
        when(sellerRepositoryImp.findById(2)).thenReturn( seller);

        //ACT & ASSERT
        Assertions.assertThrows(BadRequestException.class,()-> sellerService.setAFollower(idFollowerParam,idSellerParam));
    }

    @Test
    @DisplayName("T-0007 ✅: Verificar que la cantidad de seguidores de un determinado usuario se correcta") //US 0002
    void t0007Ok(){
        // ARRANGE
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

        CountFollowersDTO expected = new CountFollowersDTO(4, "Ahsoka", 3);

        // ACT
        CountFollowersDTO result = sellerService.countFollowers(4);

        // ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0007 🚫: Vendedor inexistente")
    void t0007Fail(){
        // ARRANGE
        when(sellerRepositoryImp.findById(4)).thenReturn(null);

        // ACT & ASSERT
        Assertions.assertThrows(NotFoundException.class, () -> sellerService.countFollowers(4));
    }
}
