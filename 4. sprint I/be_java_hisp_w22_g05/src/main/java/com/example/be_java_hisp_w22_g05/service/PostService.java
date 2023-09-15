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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
}
