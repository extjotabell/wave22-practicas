package com.example.be_java_hisp_w22_g02.service.Implementations;


import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;



import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.regex.Pattern;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class PostServiceImpl  {

    // lo eliminamos en breve
    private IUserRepository userRepository;
    private IUserService userService;
    private ObjectMapper mapper;
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[1-9]\\d*(\\.\\d+)?$");



    private boolean valid(PostDTO dto){
        return !isValidInt(dto.getUserId()) || !userRepository.existingUserById(dto.getUserId()) || !isValidInt(dto.getCategory())
                || !isValidDouble(dto.getPrice()) || dto.getProduct() == null;
    }

    private boolean isValidInt(int value) {
        return !INTEGER_PATTERN.matcher(String.valueOf(value)).matches();
    }

    private boolean isValidDouble(double value) {
        return !DOUBLE_PATTERN.matcher(String.valueOf(value)).matches();
    }

}
