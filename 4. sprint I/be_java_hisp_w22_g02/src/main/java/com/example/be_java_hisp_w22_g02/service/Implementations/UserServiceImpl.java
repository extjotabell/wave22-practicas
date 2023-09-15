package com.example.be_java_hisp_w22_g02.service.Implementations;


import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;


import com.example.be_java_hisp_w22_g02.dto.response.UserDto;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowMapper;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import java.util.List;


import java.util.ArrayList;

import java.util.Map;


@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserFollowMapper userFollowMapper;
    private final ObjectMapper mapper;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<TwoWeeksPostDTO> getLastTwoWeeksPostByUser(Long userID) {
        List<FollowedPostDTO> followedPostDTOS = new ArrayList<>();

        //List<Post> posts = userRepository.getFollowedPostLasTwoWeeks(userID);
        Map<Integer,Post> posts= userRepository.getFollowedPostLasTwoWeeks(userID);

        for (Map.Entry<Integer,Post> entry: posts.entrySet()) {
            followedPostDTOS.add(new FollowedPostDTO(entry.getKey().intValue(),entry.getValue()));
        }

        //List<FollowedPostDTO> followedPosts = userRepository.getFollowedPostLasTwoWeeks(userID);


        TwoWeeksPostDTO twoWeeksPostDTO = new TwoWeeksPostDTO(userID,posts);
    }

    @Override
    public void followUser(int userId, int userIdToFollow) {
        userRepository.followUser(userId, userIdToFollow);
    }

    @Override
    public UserDto getUser(int userId) {
        if(existsUser(userId))
            return mapper.convertValue(userRepository.findById(userId), UserDto.class);
        else
            throw new NotFoundException("No existe el usuario");
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(u -> mapper.convertValue(u, UserDto.class))
                .toList();
    }

    @Override
    public UserFollowDTO getFollowedUsersById(Integer id) {
        User userFounded = userRepository.findById(id);
        if (userFounded == null) {
            throw new NotFoundException("User with id: " + id + " not found.");
        } else {
            return userFollowMapper.toDto(userFounded);
        }
    }

    public boolean existsUser(int userId) {
        User user = userRepository.findById(userId);
        return user != null;
    }

}
