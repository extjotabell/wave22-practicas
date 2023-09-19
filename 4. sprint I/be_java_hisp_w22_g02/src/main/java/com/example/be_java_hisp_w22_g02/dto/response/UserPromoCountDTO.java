package com.example.be_java_hisp_w22_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserPromoCountDTO {
    private int userId;
    private String userName;
    private int promoProductsCount;
}
