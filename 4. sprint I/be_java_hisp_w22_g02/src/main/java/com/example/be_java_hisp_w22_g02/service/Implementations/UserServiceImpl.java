package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.UserDto;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void followUser(int userId, int userIdToFollow) {
        userRepository.followUser(userId, userIdToFollow);
    }

    public boolean existsUser(int userId) {
        User user = userRepository.getUser(userId);
        return user != null;
    }

    @Override
    public UserDto getUser(int userId) {
        if(existsUser(userId))
            return mapper.convertValue(userRepository.getUser(userId), UserDto.class);
        else
            throw new NotFoundException("No existe el usuario");
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers().stream().map(u -> mapper.convertValue(u, UserDto.class)).toList();
    }

    @Override
    public UserFollowDTO getFollowers(int id) {
        ObjectMapper mapper = new ObjectMapper();
        UserDto user = mapper.convertValue(this.userRepository.getFollowers(id), UserDto.class);
        if(user == null)
            throw new NotFoundException("No existe ningun user con el id "+id);
        UserFollowDTO userFollowDTO = new UserFollowDTO(user.getUserId(), user.getUserName());
        userFollowDTO.setFollowers(user.getFollowers().stream().map(u -> new UserDto(u.getUserId(), u.getUserName(), u.getFollowers(), null, null)).toList());
        return userFollowDTO;
    }
}
