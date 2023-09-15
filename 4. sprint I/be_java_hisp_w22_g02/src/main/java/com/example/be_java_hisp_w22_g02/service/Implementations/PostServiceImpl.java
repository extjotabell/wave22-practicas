package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPostRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PostServiceImpl implements IPostService {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[1-9]\\d*(\\.\\d+)?$");

    private final IPostRepository postRepository;
    private final IUserService userService;
    private final ObjectMapper mapper;
    public PostServiceImpl(IPostRepository postRepository, IUserService userService, ObjectMapper mapper){
        this.postRepository = postRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public PostDTO addNewPost(PostDTO dto) {
        if(dto == null || !valid(dto)){
            throw new BadRequestException("Los campos ingresados no son válidos");
        }
        return mapper.convertValue(postRepository.save(mapper.convertValue(dto, Post.class)), PostDTO.class);
    }

    private boolean valid(PostDTO dto){
        return !isValidInt(dto.getUserId()) || !userService.existsUser(dto.getUserId()) || !isValidInt(dto.getCategory())
                || !isValidDouble(dto.getPrice()) || dto.getProduct() == null;
    }

    private boolean isValidInt(int value) {
        return !INTEGER_PATTERN.matcher(String.valueOf(value)).matches();
    }

    private boolean isValidDouble(double value) {
        return !DOUBLE_PATTERN.matcher(String.valueOf(value)).matches();
    }
}
