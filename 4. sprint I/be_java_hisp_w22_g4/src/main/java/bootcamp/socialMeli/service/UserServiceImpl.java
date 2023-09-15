package bootcamp.socialMeli.service;
import bootcamp.socialMeli.dto.FollowersCountDto;
import bootcamp.socialMeli.dto.FollowersListDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public FollowersListDto getFollowersList(int userId) {
        // Get main user object
        User targetedUser = userRepository.getUserById(userId);

        List<UserDto> followers = new ArrayList<>();

        for (Integer followerId : targetedUser.getFollowers()) {
            // Get follower user object
            User follower = userRepository.getUserById(followerId);
            // Map it to UserDto
            UserDto followerDto = new UserDto(follower.getUser_id(), follower.getUser_name());
            // Add it to followers list
            followers.add(followerDto);
        }

        return new FollowersListDto(targetedUser.getUser_id(), targetedUser.getUser_name(), followers);
    }

    @Override
    public FollowersCountDto getFollowersCount(int userId) {
        User targetedUser = userRepository.getUserById(userId);

        return new FollowersCountDto(targetedUser.getUser_id(), targetedUser.getUser_name(), targetedUser.getFollowers().size());
    }


}
