package bootcamp.socialMeli.unitTests.service.userService;

import bootcamp.socialMeli.repository.UserRepositoryImpl;
import bootcamp.socialMeli.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GetAllUsersTest {

    @Mock
    private UserRepositoryImpl userRepository;

    @InjectMocks
    private UserServiceImpl userService;
    @Test
    void getAllUsersTestOk(){}
}
