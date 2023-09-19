package com.example.be_java_hisp_w22_g02.service.Implementations;


import com.example.be_java_hisp_w22_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.CountPostPromoByUserDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PostPromoByUserDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;

import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;

import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPostRepository;

import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.regex.Pattern;


@AllArgsConstructor
@Service
public class PostServiceImpl implements IPostService {


    private final IUserRepository userRepository;
    private final IPostRepository postRepository;
    private final IUserService userService;
    private final ObjectMapper mapper;
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[1-9]\\d*(\\.\\d+)?$");

    public TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order) {
        List<FollowedPostDTO> followedPostDTOS;

        if (userRepository.findById(userId) == null) {
            throw new NotFoundException("Error: the id does not exist");
        }
        if (order != null) {
            followedPostDTOS = userRepository.getFollowedPostLasTwoWeeksOrd(userId, order);
        } else {
            followedPostDTOS = userRepository.getFollowedPostLasTwoWeeks(userId);
        }

        TwoWeeksPostDTO twoWeeksPostDTO = new TwoWeeksPostDTO(userId, followedPostDTOS);

        return twoWeeksPostDTO;
    }

    @Override
    public PostDTO addNewPost(PostDTO dto) {
        if (dto == null || !valid(dto)) {
            throw new BadRequestException("Input fields are not valid");
        }
        userService.addUserPost(mapper.convertValue(dto, Post.class), dto.getUserId());
        if (dto instanceof PostPromoDTO)
            return mapper.convertValue(postRepository.save(mapper.convertValue(dto, Post.class)), PostPromoDTO.class);
        else
            return mapper.convertValue(postRepository.save(mapper.convertValue(dto, Post.class)), PostDTO.class);

    }

    @Override
    public CountPostPromoByUserDTO countPostPromoByUser(int userId) {
        if (!userService.existsUser(userId))
            throw new NotFoundException("User with id: " + userId + " doesn't exist");
        List<Post> posts = postRepository.findPromoPostByUser(userId);
        return new CountPostPromoByUserDTO(userId, userService.getUser(userId).getUserName(), posts.size());
    }

    @Override
    public PostPromoByUserDTO getPostPromoByUser(int userId) {
        if (!userService.existsUser(userId))
            throw new NotFoundException("User with id: " + userId + " doesn't exist");
        List<Post> posts = postRepository.findPromoPostByUser(userId);
        List<PostPromoDTO> postsDTO = posts.stream().map(p -> mapper.convertValue(p, PostPromoDTO.class)).toList();
        return new PostPromoByUserDTO(userId, userService.getUser(userId).getUserName(), postsDTO);
    }

    private boolean valid(PostDTO dto) {
        return !isValidInt(dto.getUserId()) || !userService.existsUser(dto.getUserId()) || !isValidInt(dto.getCategory())
                || !isValidDouble(dto.getPrice()) || dto.getProduct() == null;
    }

    private boolean isValidInt(int value) {
        return !INTEGER_PATTERN.matcher(String.valueOf(value)).matches();
    }

    private boolean isValidDouble(double value) {
        return !DOUBLE_PATTERN.matcher(String.valueOf(value)).matches();
    }
}
