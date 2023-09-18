package com.example.link_tracker.services;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.InvalidateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import com.example.link_tracker.repositories.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements ILinkService {
    private LinkRepository linkRepository;

    public LinkServiceImp(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    @Override
    public LinkDTO createLink(CreateLinkDTO createLinkDTO) {
        LinkDTO linkFounded = linkRepository.getByUrl(createLinkDTO.getUrl());
        if(linkFounded == null) {
            //Lanzar excepcion
            return null;
        }
        return linkRepository.guardar(createLinkDTO);
    }

    @Override
    public LinkDTO getLinkMetrics(Integer linkId) {
        return null;
    }

    @Override
    public void redirect(Integer linkId) {

    }

    @Override
    public void invalidateLink(InvalidateLinkDTO invalidateLinkDTO) {

    }
    //@Override
    //void validateURL();
}
