package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowMessageDto;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerServiceImp implements ISellerService{

    private final ISellerRepository sellerRepository;
    private final IUserRepository userRepository;
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
}
