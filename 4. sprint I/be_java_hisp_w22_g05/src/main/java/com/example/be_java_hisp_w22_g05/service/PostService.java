package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.AlreadyExistsException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.repository.IPostRepository;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService implements IPostService{
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;


    @Override
    public void save(PostDto postDto) {
        User user = getUser(postDto.getUserId());

        Product product = mapProduct(postDto.getProduct());

        LocalDate postDate = LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Post newPost = new Post(postDto.getId(), postDate, postDto.getCategory(), user, product, postDto.getPrice(), postDto.getHasPromo(), postDto.getDiscount());

        if(postRepository.save(newPost) == null) throw new AlreadyExistsException("El producto con id "+product.getId()+" ya existe");
    }

    private Product mapProduct(ProductDto productDto){

        return new Product(productDto.getProductId(), productDto.getProductName(), productDto.getType(), productDto.getBrand(), productDto.getColor(), productDto.getNotes());
    }

    private User getUser(int id){
        User user = userRepository.findUsersById(id);

        if(user == null) throw new NotFoundException("El usuario no existe");
        return user;
    }


    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    public List<PostDto> getListPostsFromSellersFollowed(int userId){

        ObjectMapper objectMapper = mapperBuilder.build();

        // Obtain list of sellers followed
        List<User> sellersList = userRepository.findUsersById(userId).getFollowed();

        // Obtain list of id from sellers
        List<Integer> sellersId = sellersList.stream()
                .map(User::getId)
                .toList();

        // Obtain list of posts from sellers
        List<Post> postList = postRepository.findPostAll().stream()
                .filter(post -> post.getUser().getId() == userId)
                .filter(x -> ChronoUnit.DAYS.between(x.getDate(), LocalDate.now()) <= 14)
                .toList();

        if (postList.isEmpty()){
            throw new NotFoundException("No se encontró ningún post");
        }

        return postList.stream()
                .map(p -> objectMapper.convertValue(p, PostDto.class))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


}
