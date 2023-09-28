package com.example.be_java_hisp_w22_g02.validations;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostValidator implements IValidator<PostDTO> {
    private Validator validator;
    private IUserService userService;
    @Override
    public boolean valid(PostDTO dto) {
        return !validator.isValidInt(dto.getUserId()) || !userService.existsUser(dto.getUserId()) || !validator.isValidInt(dto.getCategory())
                || !validator.isValidDouble(dto.getPrice()) || dto.getProduct() == null;
    }

    public void executeValidations(PostDTO dto){
        if(!valid(dto)){
            throw new BadRequestException("Invalid input fields");
        }
    }

}
