package com.example.link_tracker.repositories;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    private final Map<Integer, LinkDTO> datos = new HashMap<>();

    @Override
    public LinkDTO guardar(CreateLinkDTO createLinkDTO) {

        LinkDTO link = new LinkDTO();

        if (createLinkDTO.getUrl() == null) {
            link.setLinkId(datos.values().size());
            link.setUrl(createLinkDTO.getUrl());
            link.setEstado(true);
        }
        datos.put(link.getLinkId(), link);
        return null;
    }

    public LinkDTO getByUrl(String url){
        for(LinkDTO link : datos.values()){
            if (link.getUrl().equals(url)) {
                return link;
            }
        }
        return null;
    }
}
