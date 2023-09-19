package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.PromoDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.CountPromosDTO;

public interface IPromoService {
    void createPromo(PromoDTO promoDto);

    CountPromosDTO countPromoBySeller(int userId);
}
