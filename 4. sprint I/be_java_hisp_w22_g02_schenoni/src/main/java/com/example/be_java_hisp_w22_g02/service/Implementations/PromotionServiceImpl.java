package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.PromotionDto;
import com.example.be_java_hisp_w22_g02.dto.response.TotalFollowersDto;
import com.example.be_java_hisp_w22_g02.dto.response.TotalPromotionsDto;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPostRepository;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPromotionRepository;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPromotionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class PromotionServiceImpl implements IPromotionService {

    private IPromotionRepository promotionRepository;
    private IUserRepository userRepository;
    private ObjectMapper mapper;
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[1-9]\\d*(\\.\\d+)?$");

    private boolean valid(PromotionDto dto){
        return !isValidInt(dto.getUserId()) || !userRepository.existsUser(dto.getUserId()) || !isValidInt(dto.getCategory())
                || !isValidDouble(dto.getPrice()) || dto.getProduct() == null || !isValidDouble(dto.getDiscount());
    }
    private boolean isValidInt(int value) {
        return !INTEGER_PATTERN.matcher(String.valueOf(value)).matches();
    }

    private boolean isValidDouble(double value) {
        return !DOUBLE_PATTERN.matcher(String.valueOf(value)).matches();
    }

    @Override
    public void addNewPromo(PromotionDto dto) {

        if(dto == null || !valid(dto)){
            throw new BadRequestException("Los campos ingresados no son válidos");
        }
      
        Promotion newPromotion = mapper.convertValue(dto, Promotion.class);

        User userUpdated = userRepository.findById(newPromotion.getUserId());

        userUpdated.getPromotions().add(newPromotion);

        userRepository.updateUser(userUpdated);

        promotionRepository.addNewPromotion(newPromotion);

    }

    @Override
    public TotalPromotionsDto getTotalPromotionsByUserId(int userId) {
        if (!userRepository.existsUser(userId)) {
            throw new NotFoundException("User with id: " + userId + " not found.");
        }

        User user = userRepository.findById(userId);

        return new TotalPromotionsDto(user.getUserId(), user.getUserName(), user.getPromotions().size());
    }
}
