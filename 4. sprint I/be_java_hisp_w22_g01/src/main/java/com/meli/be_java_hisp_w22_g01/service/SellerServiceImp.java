package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImp implements ISellerService{

    @Autowired
    ISellerRepository sellerRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public CountFollowersDTO countFollowers(int userId) {
        Seller seller = sellerRepository.findById(userId);

        if(seller == null) {
            throw new NotFoundException("No se encontró el usuario con id: " + userId);
        }
        int count = seller.getFollowers().size();
        return new CountFollowersDTO(userId,seller.getUser_name(),count);
    }
}
