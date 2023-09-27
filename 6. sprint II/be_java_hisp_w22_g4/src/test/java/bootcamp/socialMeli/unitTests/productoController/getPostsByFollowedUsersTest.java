package bootcamp.socialMeli.unitTests.productoController;

import bootcamp.socialMeli.controller.ProductController;
import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.service.IPostService;
import bootcamp.socialMeli.service.PostServiceImpl;
import bootcamp.socialMeli.utils.NameOrderEnumDto;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class getPostsByFollowedUsersTest {

    @Mock
    PostServiceImpl postService;

    @InjectMocks
    ProductController productController;

    @Test
    @DisplayName("US 06 - T-0005 - Valid Post Date Exist - OK")
    void ValidPostDateExist(){
        //Arrange
         List<PostDto> postList = List.of(
                new PostDto(54, 6, LocalDate.of(2023, 9, 11), new ProductDto(
                        3, "Iphone", "Celulares",
                        "Apple", "Blanco",  "Nuevo de fabrica"),
                        3, 3000.00),
                new PostDto(100, 10, LocalDate.of(2023, 9, 5), new ProductDto(
                        9, "Lampara", "Velador",
                        "LuzSol", "Dorado",  "Luz calida"),
                        34, 8900.00),
                new PostDto(150, 6, LocalDate.of(2023, 9, 15), new ProductDto(
                        1, "Pochoclera", "Electrodomestico",
                        "Samsung", "Rojo",  "Pochoclera"),
                        3, 1500.50),
                new PostDto(2, 6, LocalDate.of(2023, 9, 20), new ProductDto(
                        2, "Mouse", "Gamer",
                        "Logitech", "Rosa",  "Inalambrico"),
                        200, 360.00),
                new PostDto(350, 10, LocalDate.of(2023, 9, 26), new ProductDto(
                        3, "Iphone 15", "Celulares",
                        "Apple", "Negro",  "Nuevo de fabrica"),
                        3, 3000.00));

         FollowedPostListDto followedPostListDto = new FollowedPostListDto(1,postList);

        //Act
        Mockito.when(postService.getPostsByFollowedUsers( 1, null)).thenReturn(followedPostListDto);
        ResponseEntity<FollowedPostListDto> salida = productController.getPostsByFollowedUsers(1,null);
        //Assert
        Assertions.assertEquals(followedPostListDto,salida.getBody());

    }

    @Test
    @DisplayName("US 06 - T-0005 - Valid Post Date Param Error ")
    void FollowedPostListDateErrorTest() {
        //Arrange
        int UserId = 1;
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.productController.getPostsByFollowedUsers(UserId, ProductOrderListEnum.valueOf("jkhjk")));

    }


}
