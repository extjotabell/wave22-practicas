package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.SellerDto;
import com.meli.be_java_hisp_w22_g01.dto.UserDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImp implements ISellerService{

    @Autowired
    ISellerRepository sellerRepository;
    @Autowired
    IUserRepository userRepository;

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

    @Override
    public SellerDto setAFollower(int idFollower, int idSeller) {
        Seller seller = sellerRepository.findById(idSeller);
        User user = userRepository.findById(idFollower);

        if(seller == null){
            throw new BadRequestException("No se encontro el seller");
        }else if (user == null){
            throw new BadRequestException("El usuario proporcionado no existe");
        }else{
            sellerRepository.sumAFollower(idFollower,idSeller);
        }

        return mapper.convertValue(seller,SellerDto.class);
    }

    @Override
    public List<UserMiniDTO> orderFollowersDto(int userId, String order) {
        List<User> followers;

        if (order.equals("name_asc")) {
            followers = sellerRepository.orderFollowerAsc(userId);
        }else if (order.equals("name_desc")){
            followers = sellerRepository.orderFollowerDesc(userId);
        }else{
            followers = sellerRepository.getAllFollowers(userId);
        }

        return followers.stream().map(f -> mapper.convertValue(f, UserMiniDTO.class)).toList();
    }
}
