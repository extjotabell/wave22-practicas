package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.CreateLinkDTO;
import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.exception.NotFoundException;
import com.example.LinkTracker.exception.ValidationException;
import com.example.LinkTracker.model.Link;
import com.example.LinkTracker.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Integer createNewLink(CreateLinkDTO linkDTO) {
        Link link = new ModelMapper().map(linkDTO, Link.class);
        link.setActive(true);
        Integer id = linkRepository.createNewLink(link);
        return id;
    }

    @Override
    public void addVisit(Integer id) {
        linkRepository.addVisit(id);
    }

    @Override
    public int getVisits(Integer id) {
        Link link = linkRepository.getLink(id);

        if(link == null){
            throw new NotFoundException("URL not found");
        }

        return link.getVisits();
    }

    @Override
    public void invalidateLink(Integer id) {
        Link link = linkRepository.getLink(id);

        if(link == null){
            throw new NotFoundException("ID not found");
        }

        linkRepository.invalidateLink(id);
    }

    @Override
    public LinkDTO redirect(Integer id, String password) {
        Link link = linkRepository.getLink(id);

        if(link == null || !link.isActive()){
            throw new NotFoundException("URL not found or invalidated URL ");
        }

        if(link.getPassword() != null){
            if (!link.getPassword().equals(password)){
                throw new ValidationException("Password incorrect");
            }
        }

        this.addVisit(id);

        LinkDTO linkDTO = new ModelMapper().map(link, LinkDTO.class);

        this.formatURL(linkDTO);

        return linkDTO;
    }

    private void formatURL(LinkDTO linkDTO) {
        if(!linkDTO.getUrl().substring(0,6).equals("http://") || !linkDTO.getUrl().substring(0,7).equals("https://") ){
            linkDTO.setUrl("https://" + linkDTO.getUrl());
        }
    }
}
