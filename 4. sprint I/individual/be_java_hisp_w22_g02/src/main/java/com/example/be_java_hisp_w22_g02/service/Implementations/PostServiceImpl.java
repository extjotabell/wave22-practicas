package com.example.be_java_hisp_w22_g02.service.Implementations;


import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserPromoCountDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;

import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import com.example.be_java_hisp_w22_g02.validations.PostValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;

import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPostRepository;

import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.regex.Pattern;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class PostServiceImpl implements IPostService {


    private IUserRepository userRepository;
    private IPostRepository postRepository;
    private IUserService userService;
    private PostValidator postValidator;
    private ObjectMapper mapper;
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[1-9]\\d*(\\.\\d+)?$");
    private static final String USER_ERROR = "Provided ID does not match any existing users";

    public TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order) {
        List<FollowedPostDTO> followedPostDTOS;

        if(userRepository.findById(userId) == null){
            throw new NotFoundException("Error: id does not exist");
        }
        if(order != null){
            followedPostDTOS = userRepository.getFollowedPostLasTwoWeeksOrd(userId, order);
        }else{
            followedPostDTOS = userRepository.getFollowedPostLasTwoWeeks(userId);
        }

        TwoWeeksPostDTO twoWeeksPostDTO = new TwoWeeksPostDTO(userId,followedPostDTOS);

        return twoWeeksPostDTO;
    }

    @Override
    public PostDTO addNewPost(PostDTO dto) {
        postValidator.executeValidations(dto);
        userService.addUserPost(mapper.convertValue(dto, Post.class), dto.getUserId());
        return mapper.convertValue(postRepository.save(mapper.convertValue(dto, Post.class)), PostDTO.class);
    }

    public PostDTO addPromoPost(PostDTO dto){
        return addNewPost(dto);
    }

    @Override
    public UserPromoCountDTO getTotalPromoCount(int user_id) {
        if(!userService.existsUser(user_id)){
            throw new BadRequestException(USER_ERROR);
        }
        return new UserPromoCountDTO(user_id, userService.getUser(user_id).getUserName(), userRepository.getTotalPromoCount(user_id));
    }

    @Override
    public List<PostDTO> getAllPromotionPosts(int user_id) {
        if(!userService.existsUser(user_id)){
            throw new BadRequestException(USER_ERROR);
        }
        List<PostDTO> postDTOs = postRepository
                .getAllPromotionPosts(user_id)
                .stream()
                .map(post -> mapper.convertValue(post, PostDTO.class))
                .collect(Collectors.toList());

        return postDTOs;
    }

}
