package bootcamp.socialMeli.unitTests.service.postService;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.PostRepositoryImpl;
import bootcamp.socialMeli.repository.UserRepositoryImpl;
import bootcamp.socialMeli.service.PostServiceImpl;
import bootcamp.socialMeli.service.UserServiceImpl;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class GetPostsByFollowedUsersTest {
    @Mock
    private PostRepositoryImpl postRepository;
    @Mock
    private UserServiceImpl userService;
    @Mock
    private ObjectMapper mapperMocked;

    @InjectMocks
    private PostServiceImpl postService;


    private final ObjectMapper mapper = new ObjectMapper();
    private final List<Post> postList = List.of(
            new Post(54, 6, LocalDate.now().minusWeeks(3), new Product(
                    3, "Iphone", "Celulares",
                    "Apple", "Blanco",  "Nuevo de fabrica"),
                    3, 3000.00, false, 0.0),
            new Post(100, 10, LocalDate.now().minusDays(45), new Product(
                    9, "Lampara", "Velador",
                    "LuzSol", "Dorado",  "Luz calida"),
                    34, 8900.00, false, 0.0),
            new Post(150, 6, LocalDate.now().minusDays(13), new Product(
                    1, "Pochoclera", "Electrodomestico",
                    "Samsung", "Rojo",  "Pochoclera"),
                    3, 1500.50, false, 0.0),
            new Post(2, 6, LocalDate.now().minusDays(10), new Product(
                    2, "Mouse", "Gamer",
                    "Logitech", "Rosa",  "Inalambrico"),
                    200, 360.00, false, 0.0),
            new Post(350, 10, LocalDate.now().minusDays(8), new Product(
                    3, "Iphone 15", "Celulares",
                    "Apple", "Negro",  "Nuevo de fabrica"),
                    3, 3000.00, false, 0.0));


    @Test
    @DisplayName("T-0008 - US 06 - Posts by followed users - OK")
    void getPostsByFollowedUsersTestOk()
    {
        //ARRANGE
        User user = new User(1, RolEnum.COMPRADOR,"Diego", List.of(), List.of(6,10), List.of());
        List<Post> latestPostsList = postList.stream().filter(p -> p.getDate().isAfter(LocalDate.now().minusWeeks(2))).toList();

        //ACT
        when(userService.findUserById(user.getUserId())).thenReturn(user);
        when(postRepository.getLatestPostsByUserId(6)).thenReturn(latestPostsList.stream().filter(p -> p.getUserId().equals(6)).collect(Collectors.toList()));
        when(postRepository.getLatestPostsByUserId(10)).thenReturn(latestPostsList.stream().filter(p -> p.getUserId().equals(10)).collect(Collectors.toList()));
        //Mockeo el comportamiento del mapper dentro del foreach del metodo
        when(mapperMocked.convertValue(any(), eq(PostDto.class))).thenAnswer(p -> {
            Post post = p.getArgument(0);
            return mapper.convertValue(post, PostDto.class);
        });

        FollowedPostListDto result = postService.getPostsByFollowedUsers(user.getUserId(), null);

        //ASSERT
        //El ultimo elemento de la lista es el mas antiguo
        assertTrue(result.getPosts().get(result.getPosts().size() - 1).getDate()
                .isAfter(LocalDate.now().minusWeeks(2)));
    }

    @Test
    @DisplayName("T-0008 - US 06 - Posts by followed users - User Not Found")
    void getPostsByFollowedUsersTestNotFound()
    {
        //ARRANGE
        User user = new User(80, RolEnum.COMPRADOR,"Pepito", List.of(), List.of(), List.of());

        //ACT
        when(userService.findUserById(user.getUserId())).thenThrow(NotFoundException.class);

        //ASSERT
        Assertions.assertThrows(
                NotFoundException.class,
                () -> this.postService.getPostsByFollowedUsers(user.getUserId(), null)
        );
    }
}
