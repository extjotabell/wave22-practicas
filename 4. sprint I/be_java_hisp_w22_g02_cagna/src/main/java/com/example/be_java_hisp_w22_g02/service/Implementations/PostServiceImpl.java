package com.example.be_java_hisp_w22_g02.service.Implementations;


import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromoProductCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;

import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.exception.IsEmptyException;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.mapper.PostMapper;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
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


    private final IUserRepository userRepository;
    private final IPostRepository postRepository;
    private final IUserService userService;
    private final ObjectMapper mapper;
    private PostMapper postMapper;
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[1-9]\\d*(\\.\\d+)?$");

    public TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order) {
        List<FollowedPostDTO> followedPostDTOS;

        if(userRepository.findById(userId) == null){
            throw new NotFoundException("Error: the id does not exist");
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
        if(dto == null || !valid(dto)){
            throw new BadRequestException("Input fields are not valid");
        }
        userService.addUserPost(mapper.convertValue(dto, Post.class), dto.getUserId());
        return mapper.convertValue(postRepository.save(mapper.convertValue(dto, Post.class)), PostDTO.class);
    }

    @Override
    public PostDTO addNewPromo(PostDTO dto) {
        if(dto == null || !valid(dto)){
            throw new BadRequestException("Input fields are not valid");
        }
        userService.addUserPost(mapper.convertValue(dto, Promotion.class), dto.getUserId());
        return mapper.convertValue(postRepository.savePromo(mapper.convertValue(dto, Promotion.class)), PostDTO.class);
    }
    @Override
    public PromoProductCountDTO getPromoCountByUserId(int userId) {
        User user = userRepository.findById(userId);
        if(user == null)
            throw new NotFoundException("There's no user with id: " + userId );
        List<PostDTO> promos = getPromoPostsByUserId(userId);
        return new PromoProductCountDTO(user.getUserId(), user.getUserName(), promos.size());
    }


    @Override
    public List<PostDTO> getPromoPostsByUserId(int userId) {
        User user = userRepository.findById(userId);
        if(user == null)
            throw new NotFoundException("There's no user with id: " + userId );
        List<Post> promoPosts = user.getPosts().stream().filter(p -> p instanceof Promotion && ((Promotion) p).isHasPromo()).toList();
        List<PostDTO> promoPostsDTO = new ArrayList<>();
        promoPosts.forEach(p -> promoPostsDTO.add(mapper.convertValue(p, PostDTO.class)));
        return promoPostsDTO;

    }

    private boolean valid(PostDTO dto){
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
