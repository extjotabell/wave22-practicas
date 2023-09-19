package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPromotionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class PromotionRepositoryImpl implements IPromotionRepository {

    private final Map<Integer, Promotion> dbPromotion = new HashMap<>();

    @Override
    public Promotion getById(int id) {
        return dbPromotion.get(id);
    }

    @Override
    public boolean existsById(int id) {
        return dbPromotion.containsKey(id);
    }

    @Override
    public void addNewPromotion(Promotion newPromotion) {
        newPromotion.setPostId(dbPromotion.size() + 1);
        dbPromotion.put(newPromotion.getPostId(), newPromotion);
    }
}
