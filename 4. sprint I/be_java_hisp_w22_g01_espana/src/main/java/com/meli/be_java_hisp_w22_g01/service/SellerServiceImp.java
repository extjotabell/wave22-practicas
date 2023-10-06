package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowMessageDto;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
            sellerRepository.sumAFollower(idFollower,idSeller);
        }

        return new FollowMessageDto("El user: " + idFollower + " comenzo a seguir a: " + idSeller );
    }

    @Override
    public List<UserMiniDTO> orderFollowersDto(int userId, String order) {
        List<User> followers;
        Seller seller = sellerRepository.findById(userId);
        followers = sellerRepository.getAllFollowers(seller);
        if (order.equals("name_asc")) {
            followers = followers.stream()
                    .sorted(Comparator.comparing(User::getUser_name)).toList();
        }else if (order.equals("name_desc")){
            followers = followers.stream()
                    .sorted(Comparator.comparing(User::getUser_name, Comparator.reverseOrder()))
                    .toList();
        }
        return followers.stream().map(f -> mapper.convertValue(f, UserMiniDTO.class)).toList();
    }
}