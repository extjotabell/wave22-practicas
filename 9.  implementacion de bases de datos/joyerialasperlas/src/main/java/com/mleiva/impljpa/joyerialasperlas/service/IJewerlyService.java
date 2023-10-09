package com.mleiva.impljpa.joyerialasperlas.service;


import com.mleiva.impljpa.joyerialasperlas.dto.JewerlyDTO;

import java.util.List;

public interface IJewerlyService {

    public List<JewerlyDTO> getAllJewerlys();
    public Long saveJewerly(JewerlyDTO jewerlyDTO);
    public void deleteJewerly(long id);
    public JewerlyDTO findJewerly(long id);
    public Long updateJewerly(long id, JewerlyDTO jewerlyDTO);
}
