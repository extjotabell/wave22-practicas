package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PromoDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.CountPromosDTO;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import com.meli.be_java_hisp_w22_g01.entity.Promo;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w22_g01.repository.IPromoRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoService implements IPromoService{

    @Autowired
    IPromoRepository promoRepository;

    @Autowired
    ISellerRepository sellerRepository;

    @Autowired
    IPostService postService;

    @Autowired
    IProductRepository productRepository;
    @Autowired
    IPostRepository postRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void createPromo(PromoDTO promoDto) {
        Promo promo = mapper.convertValue(promoDto, Promo.class);
        Seller seller = sellerRepository.findById(promo.getUser_id());

        if(seller == null){
            throw new NotFoundException("No existe el vendedor con id: "+ promo.getUser_id());
        }

        Product product = productRepository.getById(promo.getProduct().getProduct_id());
        if(product == null) {
            productRepository.save(promo.getProduct());
        }
        postService.createPost(promoDto);
        promoRepository.save(promo);

    }

    @Override
    public CountPromosDTO countPromoBySeller(int userId) {

        Seller seller = sellerRepository.findById(userId);
        if(seller == null){
            throw new NotFoundException("No existe el vendedor con id: "+ userId);
        }

        List<Promo> promoList = promoRepository.getAllPromos().stream().filter(promo -> promo.getUser_id() == userId).toList();

        return new CountPromosDTO(userId, seller.getUser_name(), promoList.size());
    }
}
