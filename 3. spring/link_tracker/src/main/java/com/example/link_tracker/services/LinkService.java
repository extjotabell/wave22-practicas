package com.example.link_tracker.services;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.InvalidateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import com.example.link_tracker.dto.MetricDTO;
import com.example.link_tracker.exception.NotAuthorizedException;
import com.example.link_tracker.exception.NotFoundUrlException;
import com.example.link_tracker.repositories.ILinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    private ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    @Override
    public LinkDTO createLink(CreateLinkDTO createLinkDTO) {
        LinkDTO linkFounded = linkRepository.getByUrl(createLinkDTO.getUrl());
        if(linkFounded != null) {
            //Lanzar excepcion
            return null;
        }
        return linkRepository.guardar(createLinkDTO);
    }

    @Override
    public MetricDTO getLinkMetrics(Integer linkId) {
        LinkDTO link = linkRepository.getLinkById(linkId);
        if (link == null){
            return null;
        }
         return new MetricDTO(link.getLinkId(), link.getRedirectCount(), link.getUrl());
    }

    @Override
    public String redirect(Integer linkId, String password) {
        LinkDTO link = linkRepository.getLinkById(linkId);
        if (link == null || !link.getIsActive()){
            throw new NotFoundUrlException("Url not found");
        }
        if (!link.getPassword().equals(password)){
            throw new NotAuthorizedException("Not authorized");
        }
        link.setRedirectCount();
        linkRepository.updateLink(link);
        return link.getUrl();
    }

    @Override
    public void invalidateLink(Integer linkId) {
        LinkDTO link = linkRepository.getLinkById(linkId);
        if (link == null || !link.getIsActive()){
            throw new NotFoundUrlException("Url not found");
        }
        linkRepository.invalidateLink(link);
    }
}
