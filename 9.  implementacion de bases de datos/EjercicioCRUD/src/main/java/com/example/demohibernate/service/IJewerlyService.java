package com.example.demohibernate.service;

import com.example.demohibernate.dto.JewerlyDto;
import com.example.demohibernate.model.Jewerly;
import java.util.List;

public interface IJewerlyService {
    public List<JewerlyDto> getJewerly();
    public Long saveJewerly(JewerlyDto dto);
    public void updateJewerly(long id, JewerlyDto dto);
    public void deleteJewerly(long id);
    public JewerlyDto findJewerly(long id);
}
