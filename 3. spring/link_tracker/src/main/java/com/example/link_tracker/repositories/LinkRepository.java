package com.example.link_tracker.repositories;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import com.example.link_tracker.dto.MetricDTO;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {

    private final Map<Integer, LinkDTO> datos = new HashMap<>();

    @Override
    public LinkDTO guardar(CreateLinkDTO createLinkDTO) {

        LinkDTO link = new LinkDTO();
        link.setLinkId(datos.values().size() + 1);
        link.setUrl(createLinkDTO.getUrl());
        link.setIsActive(true);
        datos.put(link.getLinkId(), link);
        return link;
    }

    public LinkDTO getByUrl(String url){
        for(LinkDTO link : datos.values()){
            if (link.getUrl().equals(url)) {
                return link;
            }
        }
        return null;
    }

    @Override
    public LinkDTO getLinkById(Integer linkId) {
        return datos.get(linkId);
    }

    @Override
    public LinkDTO updateLink(LinkDTO link) {
        return datos.put(link.getLinkId(), link);
    }

    @Override
    public void invalidateLink(LinkDTO link) {
        link.setIsActive(false);
        datos.put(link.getLinkId(), link);
    }
}
