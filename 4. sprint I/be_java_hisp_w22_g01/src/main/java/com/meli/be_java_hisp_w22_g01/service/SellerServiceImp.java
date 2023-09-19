package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PromoDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.CountPromotionsDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowMessageDto;
import com.meli.be_java_hisp_w22_g01.dto.response.ListPromotionPostDTO;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.PromoPost;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
// import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImp implements ISellerService{

    private final ISellerRepository sellerRepository;
    private final IUserRepository userRepository;
    private final ObjectMapper mapper;
    // private final IPostRepository postRepository;
    @Override
    public CountFollowersDTO countFollowers(int userId) {
        Seller seller = sellerRepository.findById(userId);

        if(seller == null) {
            throw new NotFoundException("No se encontró el usuario con id: " + userId);
        }
        int count = seller.getFollowers().size();
        return new CountFollowersDTO(userId,seller.getUser_name(),count);
    }

    @Override
    public FollowMessageDto setAFollower(int idFollower, int idSeller) {

        Seller seller = sellerRepository.findById(idSeller);
        User user = userRepository.findById(idFollower);

        if(seller == null){
            throw new BadRequestException("No se encontro el seller");
        }else if (user == null){
            throw new BadRequestException("El usuario proporcionado no existe");
        }
        if(seller.getFollowers().contains(user)){
            throw new BadRequestException("Ya es seguidor de ese seller");
        }else{
            sellerRepository.addFollower(idFollower,idSeller);
        }

        return new FollowMessageDto("El user: " + idFollower + " comenzo a seguir a: " + idSeller );
    }

    @Override
    public CountPromotionsDTO countProductsInPromotion(int userId) {
        Seller seller = sellerRepository.findById(userId);

        if(seller == null) {
            throw new NotFoundException("No se encontró el vendedor con id: " + userId);
        }

        /*
        Alternative way of obtaining with the post repository instead through a seller
        List<Post> promoList = postRepository.getAllPosts().stream()
                .filter(post -> post.getUser_id() == userId)
                .filter(post -> post instanceof PromoPost)
                .toList();
        */

        List<Post> postInPromo = seller.getPosts().stream().filter(post -> post instanceof PromoPost).toList();
        return new CountPromotionsDTO(userId,seller.getUser_name(),postInPromo.size());
    }

    @Override
    public ListPromotionPostDTO getProductsInPromotion(int userId) {
        Seller seller = sellerRepository.findById(userId);

        if(seller == null) {
            throw new NotFoundException("No se encontró el vendedor con id: " + userId);
        }

        List<Post> postInPromo = seller.getPosts().stream().filter(post -> post instanceof PromoPost).toList();
        List<PromoDTO> promoDTOS = postInPromo.stream().map(post -> mapper.convertValue(post, PromoDTO.class)).toList();
        return new ListPromotionPostDTO(userId,seller.getUser_name(), promoDTOS);
    }
}
