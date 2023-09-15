package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDto;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowedMapper;
import com.example.be_java_hisp_w22_g02.mapper.UserMapper;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserFollowedMapper userFollowMapper;
    private final UserMapper userMapper;
    private final ObjectMapper mapper;

    @Override
    public UserFollowedDTO getFollowedUsersById(Long id) {
        User userFounded = userRepository.findById(id);
        if (userFounded == null) {
            throw new NotFoundException("User with id: " + id + " not found.");
        } else {
            // Mapeo la lista de usuarios seguidos a DTO para mostrar atributos segun requerimiento
            List<User> usersFollowed = userFounded.getFollowed();
            List<UserDTO> usersFollowedDto = usersFollowed.stream().map(userMapper::toDto).toList();

            UserFollowedDTO userFoundedDto = userFollowMapper.toDto(userFounded);
            userFoundedDto.setFollowed(usersFollowedDto);
            return userFoundedDto;
        }
    }



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


}
