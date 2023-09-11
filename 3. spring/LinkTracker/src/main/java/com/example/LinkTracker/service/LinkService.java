package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.model.Link;
import com.example.LinkTracker.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public Integer createNewLink(LinkDTO linkDTO) {
        Link link = new ModelMapper().map(linkDTO, Link.class);
        return linkRepository.createNewLink(link);
    }

    @Override
    public void addVisit(Integer id) {
        linkRepository.addVisit(id);
    }

    @Override
    public int getVisits(Integer id) {
        return linkRepository.getVisits(id);
    }

    @Override
    public void invalidateLink(Integer id) {
        linkRepository.invalidateLink(id);
    }

    @Override
    public LinkDTO redirect(Integer id) {
        Link link = linkRepository.getLink(id);
        if(link != null && link.isActive())
            addVisit(id);
        else
            throw new RuntimeException();
        return new ModelMapper().map(link, LinkDTO.class);
    }
}
