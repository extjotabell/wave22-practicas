package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.mapper.PromotionMapper;
import com.example.be_java_hisp_w22_g02.mapper.UserMapper;
import com.example.be_java_hisp_w22_g02.repository.Implementations.PromotionRepositoryImpl;
import com.example.be_java_hisp_w22_g02.repository.Implementations.UserRepositoryImpl;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements IPromotionService {

    private final PromotionRepositoryImpl promotionRepository;
    private final PromotionMapper promotionMapper;
    private final UserRepositoryImpl userRepository;
    private final UserMapper userMapper;

    @Override
    public void addPromoPost(PostPromoDTO productDto) {
        ensureNotNull(productDto);
        Promotion post = promotionMapper.toEntity(productDto);
        User userFounded = userRepository.findById(post.getUserId());
        if (userFounded == null) {
            throw new NotFoundException("Error. User does not exists");
        } else {
            userFounded.getPosts().add(post);
            promotionRepository.add(post);
        }
    }

    @Override
    public PromoPostCountDTO getPromoPostsById(Integer id) {
        User userFounded = userRepository.findById(id);
        if (userFounded == null) {
            throw new NotFoundException("Error. User does not exists");
        }
        return new PromoPostCountDTO(userFounded.getUserId(), userFounded.getUserName(), userFounded.getPosts().size());
    }

    @Override
    public UserDTO getAllPostsById(Integer id) {
        User userFounded = userRepository.findById(id);
        if (userFounded == null) {
            throw new NotFoundException("Error. User does not exists");
        }
        return userMapper.toDto(userFounded);
    }

    void ensureNotNull(PostPromoDTO postPromoDTO) {
        if(postPromoDTO == null) {
            throw new BadRequestException("Error. Input format is incorrect");
        }
    }
}
