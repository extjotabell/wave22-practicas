package bootcamp.socialMeli.service;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;
    /*private final IPostService postService;
    private final IProductService productService;*/

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
        //this.postService = postService;
        //this.productService = productService;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
