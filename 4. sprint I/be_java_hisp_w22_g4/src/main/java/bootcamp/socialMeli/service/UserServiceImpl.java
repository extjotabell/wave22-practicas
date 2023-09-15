package bootcamp.socialMeli.service;
import bootcamp.socialMeli.dto.FollowersCountDto;
import bootcamp.socialMeli.dto.FollowersListDto;
import bootcamp.socialMeli.dto.NameOrderEnumDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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

    // US 02
    @Override
    public FollowersCountDto getFollowersCount(int userId) {
        User targetedUser = findUserById(userId);

        return new FollowersCountDto(targetedUser.getUser_id(), targetedUser.getUser_name(), targetedUser.getFollowers().size());
    }

    // US 03
    @Override
    public FollowersListDto getFollowersList(int userId, NameOrderEnumDto nameOrder) {
        // Get main user object
        User targetedUser = findUserById(userId);

        //Create list with followers
        List<UserDto> followers = targetedUser.getFollowers().stream()
                .map(followerId -> {
                    User follower = findUserById(followerId);
                    return new UserDto(follower.getUser_id(), follower.getUser_name());
                })
                .toList();

        //Create comparator to sort
        Comparator<UserDto> usernameComparator = Comparator.comparing(UserDto::getUser_name);

        //Sort depending parameter input
        if(nameOrder == NameOrderEnumDto.name_desc){
            followers.sort(usernameComparator.reversed());
        }
        else{
            followers.sort(usernameComparator);
        }

        return new FollowersListDto(targetedUser.getUser_id(), targetedUser.getUser_name(), followers);
    }

    // General use
    @Override
    public User findUserById(int userId) {
        return userRepository.findUserById(userId).orElseThrow(
                () -> new NotFoundException("User with ID #" + userId + " not found")
        );


    }


}
