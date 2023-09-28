package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.AlreadyExistsException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.exception.RequestParamInvalidException;
import com.example.be_java_hisp_w22_g05.utils.PostMapper;
import com.example.be_java_hisp_w22_g05.repository.IPostRepository;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    @Override
    public void saveNewPost(PostDto postDto) {
        User user = getUser(postDto.getUserId());

        Product product = mapProduct(postDto.getProduct());

        Post newPost = new Post(postDto.getId(), postDto.getDate(), postDto.getCategory(), user, product, postDto.getPrice(), postDto.getHasPromo(), postDto.getDiscount());

        if (postRepository.save(newPost) == null)
            throw new AlreadyExistsException("El producto con id " + product.getId() + " ya existe");
    }

    private Product mapProduct(ProductDto productDto) {

        return new Product(productDto.getId(), productDto.getName(), productDto.getType(), productDto.getBrand(), productDto.getColor(), productDto.getNotes());
    }

    private User getUser(int id) {
        User user = userRepository.findUsersById(id);

        if (user == null) throw new NotFoundException("El usuario " + id +  " no existe");
        return user;
    }


    public List<PostDto> getListPostsFromSellersFollowed(int userId, String order) {

        // Obtain list of sellers followed
        //List<User> sellersList = userRepository.findUsersById(userId).getFollowed();
        User seller = userRepository.findUsersById(userId);
        if(seller == null){
            throw new NotFoundException("No existe el vendedor con ese id");
        }

        List<User> sellersList = seller.getFollowed();

        // Obtain list of id from sellers
        List<Integer> sellersId = sellersList.stream()
                .map(User::getId)
                .toList();

        // Obtain list of posts from sellers
        List<Post> postList = postRepository.findPostAll().stream()
                .filter(x -> ChronoUnit.DAYS.between(x.getDate(), LocalDate.now()) <= 14)
                .filter(x -> ChronoUnit.DAYS.between(x.getDate(), LocalDate.now()) >= 0)
                .filter(post -> sellersId.contains(post.getUser().getId()))
                .toList();

        if (postList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún post");
        }

        //Aca ordenamos
        validateOrder(order);
        return orderList(postList, order!= null && order.equals("date_asc"));
    }

    private void validateOrder(String order) {
        if(order != null && !order.equals("date_asc") && !order.equals("date_desc")){
            throw new RequestParamInvalidException("Request param invalido, opciones validas: <date_asc> o <date_desc>");
        }
    }

    private List<PostDto> orderList(List<Post> posts, boolean isAsc) {
        return posts.stream()
                .filter(Objects::nonNull).sorted((x, y) -> isAsc ? x.getDate().compareTo(y.getDate()) : y.getDate().compareTo(x.getDate()))
                .map(PostMapper::toPostDTO)
                .collect(Collectors.toList());
    }

}