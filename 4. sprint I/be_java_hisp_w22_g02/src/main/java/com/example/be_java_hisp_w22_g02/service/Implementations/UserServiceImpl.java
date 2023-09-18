package com.example.be_java_hisp_w22_g02.service.Implementations;

<<<<<<< HEAD


import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;


import com.example.be_java_hisp_w22_g02.dto.response.TotalFollowersDto;


=======
import com.example.be_java_hisp_w22_g02.dto.response.UserDto;
>>>>>>> c6dd9e47ad884c495969976fad7f509bfe251aea
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowMapper;
<<<<<<< HEAD


import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.example.be_java_hisp_w22_g02.mapper.UserFollowerMapper;



=======
import com.example.be_java_hisp_w22_g02.mapper.UserMapper;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
>>>>>>> c6dd9e47ad884c495969976fad7f509bfe251aea
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final UserFollowMapper userFollowMapper;
<<<<<<< HEAD

    private final UserFollowerMapper userFollowerMapper;

=======
    private final UserMapper userMapper;
>>>>>>> c6dd9e47ad884c495969976fad7f509bfe251aea
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
    public UserDto getUser(int userId) {
        if(existsUser(userId))
            return userMapper.toDto(userRepository.findById(userId));
        else
            throw new NotFoundException("User with id: " + userId + " not found.");
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
