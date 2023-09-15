package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.TotalFollowersDto;
import com.example.be_java_hisp_w22_g02.dto.response.UserDto;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowerDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowMapper;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowerMapper;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserFollowMapper userFollowMapper;
    private final UserFollowerMapper userFollowerMapper;
    private final ObjectMapper mapper;


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
    public UserFollowerDTO getFollowers(int id) {
        User user = userRepository.findById(id);
        if(user == null)
            throw new NotFoundException("User with id: " + id + " not found.");
        return userFollowerMapper.toDto(user);
    }

    @Override
    public TotalFollowersDto getTotalFollowersByUserId(int userId) {
        if (!existsUser(userId)){
            throw new NotFoundException("User with id: " + userId + " not found.");
        }

        User user = userRepository.findById(userId);

        return new TotalFollowersDto(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

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
