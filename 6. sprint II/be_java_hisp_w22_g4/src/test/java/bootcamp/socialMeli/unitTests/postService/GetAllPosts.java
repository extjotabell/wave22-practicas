package bootcamp.socialMeli.unitTests.postService;

import bootcamp.socialMeli.repository.PostRepositoryImpl;
import bootcamp.socialMeli.service.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GetAllPosts {

    @Mock
    private PostRepositoryImpl postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void getAllPostsTestOk(){}
}
