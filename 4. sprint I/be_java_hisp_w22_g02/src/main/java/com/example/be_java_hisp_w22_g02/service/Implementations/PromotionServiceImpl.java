package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.PromotionPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionListDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.mapper.PromotionMapper;
import com.example.be_java_hisp_w22_g02.mapper.UserFollowMapper;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPromotionRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPromotionService;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements IPromotionService {
    IPromotionRepository promoRepository;
    IUserService userService;
    IPostService postService;

    private final PromotionMapper promotionMapper;
    @Override
    public PromotionDTO addPromotionPost(PromotionPostDTO promotionPostDTO) {
        if(promotionPostDTO == null){
            throw new BadRequestException("Los campos no son validos");
        }
        Promotion promo = promotionMapper.toEntity(promotionPostDTO);

       String message = promoRepository.addPromotionPost(promo);
       PromotionDTO promoResponse = new PromotionDTO(message);
       return promoResponse;

    }

    @Override
    public PromotionCountDTO getPromotionsById(int id) {
       List<Promotion> promotionList = promoRepository.getPromotionsById(id);
       int count = promotionList.size();
        UserDTO user = userService.getUser(id);

       return new PromotionCountDTO(user.getUserId(),user.getUserName(),count);
    }

    @Override
    public PromotionListDTO getListPromotionsById(int userId) {
       List<Promotion> promotionlist = promoRepository.getPromotionsById(userId);

       PromotionListDTO promotionListDTO = new PromotionListDTO(userId,
               userService.getUser(userId).getUserName(),
               promotionlist);

        return promotionListDTO;
    }
}
