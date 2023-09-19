package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{
    private final ObjectMapper objectMapper;
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    // US 01
    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("IDs enviados iguales");
        }

        User user = this.findUserById(userId);
        User userToFollow = this.findUserById(userIdToFollow);

        if (userToFollow.getRol().equals(RolEnum.COMPRADOR)) {
            throw new BadRequestException("Intentando seguir un COMPRADOR");
        }

        if (user.getFollowed().contains(userIdToFollow)) {
            throw new BadRequestException("Ya sigue al usuario");
        }

        this.userRepository.addFollower(user, userToFollow);
    }

    // US 02
    @Override
    public FollowersCountDto getFollowersCount(int userId) {
        User targetedUser = findUserById(userId);

        return new FollowersCountDto(
                targetedUser.getUser_id(),
                targetedUser.getUser_name(),
                targetedUser.getFollowers().size()
        );
    }

    // US 03
    // US 08
    @Override
    public FollowersListDto getFollowersList(int userId, NameOrderEnumDto nameOrder) {
        // Get main user object
        User targetedUser = findUserById(userId);

        // Create list with followers & Sort
        List<UserDto> followers = this.sortFollowsByName(targetedUser.getFollowers(), nameOrder);

        return new FollowersListDto(targetedUser.getUser_id(), targetedUser.getUser_name(), followers);
    }

    // US 04
    // US 08
    @Override
    public FollowedListDto getFollowingList(int userId, NameOrderEnumDto nameOrder) {
        // Get main user object
        User targetedUser = findUserById(userId);

        // Create list with followers & Sort
        List<UserDto> followed = this.sortFollowsByName(targetedUser.getFollowed(), nameOrder);

        return new FollowedListDto(userId, targetedUser.getUser_name(), followed);
    }

    // US 07
    @Override
    public UserDto removeFollower(int userId, int userIdToUnfollow) {
        if (userId == userIdToUnfollow){
            throw new BadRequestException("Los ids enviados son iguales");
        }

        User user = findUserById(userId);
        User userToUnfollow = findUserById(userIdToUnfollow);

        if(!user.getFollowed().contains(userToUnfollow.getUser_id())){
            throw  new BadRequestException("No sigue al usuario seleccionado");
        }

        return objectMapper.convertValue(userRepository.removeFollower(user, userToUnfollow), UserDto.class);
    }

    // General use
    @Override
    public List<UserDto> getAllUsers() {
        return this.userRepository.getAllUsers()
                .stream()
                .map(u -> objectMapper.convertValue(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPostToUser(User owner, int postId) {
        this.userRepository.addPostToUser(owner, postId);
    }

    @Override
    public String getUserName(Integer userId) {
        return this.findUserById(userId).getUser_name();
    }

    @Override
    public User findUserById(int userId) {
        return userRepository.findUserById(userId).orElseThrow(
                () -> new NotFoundException("User with ID #" + userId + " not found")
        );
    }

    private List<UserDto> sortFollowsByName(List<Integer> followsIds, NameOrderEnumDto nameOrder){
        Comparator<UserDto> usernameComparator = Comparator.comparing(UserDto::getUser_name);
        return followsIds.stream()
                .map(followerId -> objectMapper.convertValue(findUserById(followerId), UserDto.class))
                .sorted(nameOrder.equals(NameOrderEnumDto.name_asc) ? usernameComparator : usernameComparator.reversed())
                .toList();
    }
}
