package com.example.be_java_hisp_w22_g02.service.Implementations;


import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;



import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowMapper;



import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.example.be_java_hisp_w22_g02.mapper.UserFollowerMapper;

import com.example.be_java_hisp_w22_g02.mapper.UserMapper;

import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final UserFollowMapper userFollowMapper;


    private final UserFollowerMapper userFollowerMapper;


    private final UserMapper userMapper;

    private final ObjectMapper mapper;


    @Override
    public void followUser(int userId, int userIdToFollow) {
        if(!existsUser(userId))
            throw new NotFoundException("User with id: " + userId + " not found.");
        if(!existsUser(userIdToFollow))
            throw new NotFoundException("User with id: " + userIdToFollow + " not found.");
        userRepository.followUser(userId, userIdToFollow);
    }

    @Override
    public UserDTO getUser(int userId) {
        if(existsUser(userId))
            return userMapper.toDto(userRepository.findById(userId));
        else
            throw new NotFoundException("User with id: " + userId + " not found.");
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(u -> mapper.convertValue(u, UserDTO.class))
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
