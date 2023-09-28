package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IUserRepository;
import bootcamp.socialMeli.utils.NameOrderEnumDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        return new FollowersCountDto(targetedUser.getUserId(), targetedUser.getUserName(), targetedUser.getFollowers().size());
    }

    // US 03
    // US 08
    @Override
    public FollowersListDto getFollowersList(int userId, NameOrderEnumDto nameOrder) {
        // Get main user object
        User targetedUser = findUserById(userId);

        //Create list with followers
        List<UserDto> followers = new ArrayList<>(targetedUser.getFollowers()
                .stream()
                .map(followerId -> {
                    User follower = findUserById(followerId);
                    return new UserDto(follower.getUserId(), follower.getUserName());
                })
                .toList());

        // Sort depending on parameter input
        sortUserDtoList(followers, nameOrder);

        return new FollowersListDto(targetedUser.getUserId(), targetedUser.getUserName(), followers);
    }

    // US 04
    // US 08
    @Override
    public FollowedListDto getFollowingList(int userId, NameOrderEnumDto nameOrder) {
        User targetedUser = findUserById(userId);
        List<UserDto> followed = new ArrayList<>();
        for (int idFollowed : targetedUser.getFollowed()){
            User userFollowed = findUserById(idFollowed);
            UserDto userDto = new UserDto(userFollowed.getUserId(), userFollowed.getUserName());
            followed.add(userDto);
        }

        // Sort depending on parameter input
        sortUserDtoList(followed, nameOrder);
        
        return new FollowedListDto(userId, targetedUser.getUserName(), followed);
    }

    // US 07
    @Override
    public UserDto removeFollower(int userId, int userIdToUnfollow) {
        if(userId != userIdToUnfollow){
            User user = findUserById(userId);
            User userToUnfollow = findUserById(userIdToUnfollow);

            if(!user.getFollowed().contains(userToUnfollow.getUserId())){
                throw  new BadRequestException("No sigue al usuario seleccionado");
            }
            return objectMapper.convertValue(userRepository.removeFollower(user, userToUnfollow), UserDto.class);
        } else {
            throw new BadRequestException("Los ids enviados son iguales");
        }
    }

    // General use
    @Override
    public User findUserById(int userId) {
        return userRepository.findUserById(userId).orElseThrow(
                () -> new NotFoundException("Usuario con id #" + userId + " no encontrado")
        );
    }

    private void sortUserDtoList(List<UserDto> listToSort, NameOrderEnumDto criteria) {
        // Create comparator to sort
        Comparator<UserDto> usernameComparator = Comparator.comparing(UserDto::getUserName);

        // Sort depending parameter input
        if (criteria == NameOrderEnumDto.name_desc){
            listToSort.sort(usernameComparator.reversed());
        } else {
            listToSort.sort(usernameComparator);
        }
    }
}
