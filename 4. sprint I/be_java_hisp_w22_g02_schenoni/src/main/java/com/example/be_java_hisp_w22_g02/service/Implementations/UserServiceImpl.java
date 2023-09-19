package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;



import com.example.be_java_hisp_w22_g02.dto.response.TotalFollowersDto;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowerDTO;

import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.entity.UserFollow;
import com.example.be_java_hisp_w22_g02.exception.IsEmptyException;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowMapper;




import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.example.be_java_hisp_w22_g02.mapper.UserFollowerMapper;

import com.example.be_java_hisp_w22_g02.mapper.UserMapper;

import com.example.be_java_hisp_w22_g02.mapper.UserFollowedMapper;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;


    private final UserFollowMapper userFollowMapper;


    private final UserFollowerMapper userFollowerMapper;


    private final UserMapper userMapper;


    private final UserFollowedMapper userFollowedMapper;

    private final ObjectMapper mapper;


    @Override
    public void followUser(int userId, int userIdToFollow) {
        if(!existsUser(userId))
            throw new NotFoundException("User with id: " + userId + " not found.");
        if(!existsUser(userIdToFollow))
            throw new NotFoundException("User with id: " + userIdToFollow + " not found.");
        if(userId == userIdToFollow)
            throw new BadRequestException("User ids can't be the same");
        userRepository.followUser(userId, userIdToFollow);
    }

    @Override

    public UserDTO getUser(int userId) {
        if(existsUser(userId))
            return userMapper.toDto(userRepository.findById(userId));
        else
            throw new NotFoundException("No existe el usuario");
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(u -> mapper.convertValue(u, UserDTO.class))
                .toList();
    }

    @Override
    public UserFollowerDTO getFollowers(int id, String order) {
        User user = userRepository.findById(id);
        if (user == null)
            throw new NotFoundException("User with id: " + id + " not found.");
        if(order != null){
            User sortedFollowers = sortingFollowers(user, order);
            return userFollowerMapper.toDto(sortedFollowers);
        }
        return userFollowerMapper.toDto(user);
    }

    @Override
    public TotalFollowersDto getTotalFollowersByUserId(int userId) {

        if (!userRepository.existsUser(userId)) {
            throw new NotFoundException("User with id: " + userId + " not found.");
        }

        User user = userRepository.findById(userId);

        return new TotalFollowersDto(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        User mainUser = userRepository.findById(userId);
        User targetUserToUnfollow = userRepository.findById(userIdToUnfollow);

        if (mainUser == null) {
            throw new NotFoundException("User with id: " + userId + " not found.");
        } else if (targetUserToUnfollow == null) {
            throw new NotFoundException("User with id: " + userIdToUnfollow + " not found.");
        } else {
            List<UserFollow> userFollowedList = mainUser.getFollowed();
            List<UserFollow> userFollowersList = targetUserToUnfollow.getFollowers();
            deleteUserFromList(userFollowedList, getUserFollowById(userFollowedList,userIdToUnfollow));
            deleteUserFromList(userFollowersList, getUserFollowById(userFollowersList, userId));
        }
    }

    public UserFollowedDTO getFollowedUsersById(Integer id, String order) {
        User userFounded = userRepository.findById(id);
        if (userFounded == null) {
            throw new NotFoundException("User with id: " + id + " not found.");
        } else if (order != null) {
            User sortedFollowers = sortingFollowed(userFounded, order);
            return userFollowedMapper.toDto(sortedFollowers);
        } else {
            return userFollowedMapper.toDto(userFounded);
        }
    }

    public boolean existsUser(int userId) {
        User user = userRepository.findById(userId);
        return user != null;
    }

    public UserFollow getUserFollowById(List<UserFollow> users, int id) {
        UserFollow userFounded = null;
        for (UserFollow u: users) {
            if(u.getUserId() == id) {
                userFounded = u;
            }
        }
        return userFounded;
    }

    private void deleteUserFromList(List<UserFollow> users, UserFollow user) {
        if(users.isEmpty()) {
            throw new IsEmptyException("Error. List is empty.");
        } else {
            users.remove(user);
        }
    }

    private User sortingFollowers(User user, String order){
        sortingByNameValidation(order);
        if(Objects.equals(order, "name_asc")){
            user.setFollowers(user.getFollowers().stream().sorted(Comparator.comparing(UserFollow::getUserName)).collect(Collectors.toList()));
        }
        else{
            user.setFollowers(user.getFollowers().stream().sorted(Comparator.comparing(UserFollow::getUserName).reversed()).collect(Collectors.toList()));
        }
        return user;
    }

    private User sortingFollowed(User user, String order){
        sortingByNameValidation(order);
        if(Objects.equals(order, "name_asc")){
            user.setFollowed(user.getFollowed().stream().sorted(Comparator.comparing(UserFollow::getUserName)).collect(Collectors.toList()));
        }
        else{
            user.setFollowed(user.getFollowed().stream().sorted(Comparator.comparing(UserFollow::getUserName).reversed()).collect(Collectors.toList()));
        }
        return user;
    }
    private void sortingByNameValidation(String order){
        if(order != null && !order.equals("name_asc") && !order.equals("name_desc"))
            throw new BadRequestException("The sorting order "+order+" doesn't exist.");
    }

    public void addUserPost(Post post, Integer userId){
        UserDTO userDTO = getUser(userId);
        userDTO.getPosts().add(post);

        User entity = userRepository.findById(userId);
        entity.getPosts().add(post);
    }
}
