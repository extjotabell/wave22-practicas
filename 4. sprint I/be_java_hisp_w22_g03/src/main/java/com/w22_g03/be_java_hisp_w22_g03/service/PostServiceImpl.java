package com.w22_g03.be_java_hisp_w22_g03.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.exception.NotFoundException;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepository;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    private UserRepository userRepository;

    @Override
    public PostDTO addPost(PostDTO postDTO) {

        User user = userRepository.findById(postDTO.getUserId());
        if (Objects.isNull(user)) {
            throw new NotFoundException("User not found");
        }

        ModelMapper mapper = new ModelMapper();
//        ObjectMapper mapper = new ObjectMapper();
//        Post post = mapper.convertValue(postDTO, Post.class);

        Post post = mapper.map(postDTO, Post.class);
//        post.setProduct(mapper.convertValue(postDTO.getProduct(), Product.class));
        post.setProduct(mapper.map(postDTO.getProduct(), Product.class));
        post.setUser(user);

        this.postRepository.savePost(post);
        return postDTO;
    }

    @Override
    public List<PostDTO> getFollowedUsersPostsById(long userId) {
        User user = userRepository.findById(userId);
        ObjectMapper mapper = new ObjectMapper();
        List<Post> twoWeekOldPostsBySellerV2 = postRepository.findTwoWeekOldPostsFromFollowedByUser(user);
        return twoWeekOldPostsBySellerV2.stream().map(p -> mapper.convertValue(p, PostDTO.class)).toList();
    }

    @Override
    public List<PostDTO> getFollowedUsersPostsById(long userId, String order) {
        List<PostDTO> posts = getFollowedUsersPostsById(userId);
        if(order.equals("order_asc")){
            return posts.stream().sorted(Comparator.comparing(PostDTO::getDate)).toList();
        }else{
            return posts.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList();
        }
    }
}
