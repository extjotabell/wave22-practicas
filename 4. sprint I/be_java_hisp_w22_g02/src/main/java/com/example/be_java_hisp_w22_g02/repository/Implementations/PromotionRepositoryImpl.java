package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPromotionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PromotionRepositoryImpl implements IPromotionRepository {
    private final Map<Long, Promotion> dbPromotion = new HashMap<>();

}
