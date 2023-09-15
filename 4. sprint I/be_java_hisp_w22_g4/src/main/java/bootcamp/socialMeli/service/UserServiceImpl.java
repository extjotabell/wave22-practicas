package bootcamp.socialMeli.service;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    ObjectMapper mapper = new ObjectMapper();
    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        return userList.stream()
                .map(user -> mapper.convertValue(user,UserDto.class))
                .collect(Collectors.toList());
    }
}
