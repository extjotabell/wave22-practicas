package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.repository.ILinkTrackerRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    ILinkTrackerRepository linkRepository;
    public LinkService(ILinkTrackerRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public String getUrlLinkById(int id){
         Link link = linkRepository.getLinkById(id) ;
         return link.getUrl();
    }

    @Override
    public int createLink(LinkDTO linkDTO) {
        Link link = Link.builder()
                .redirectionCount(0)
                .url(linkDTO.getUrl())
                .isValid(linkDTO.getIsValid())
                .id(linkDTO.getId())
                .password(linkDTO.getPassword())
                .build();
        return linkRepository.createLink(link);
    }

    @Override
    public void invalidateLink(int linkId) {
        Link link = linkRepository.getLinkById(linkId);
        link.setValid(false);
        linkRepository.updateLink(link);
    }

    @Override
    public boolean isValidLink(int linkId) {
        Link link = linkRepository.getLinkById(linkId);
        return link != null && link.isValid();
    }

    @Override
    public void increaseRedirectAmount(int linkId) {
        Link link = linkRepository.getLinkById(linkId);
        link.setRedirectionCount(link.getRedirectionCount() + 1);
        linkRepository.updateLink(link);
    }

    @Override
    public int getMetric(int linkID){
        Link link = linkRepository.getLinkById(linkID);
        return linkRepository.getMetric(link);
    }

    @Override
    public boolean isValidPassword(String pass,int linkID){
        return linkRepository.isValidPassword(pass, linkID);
    }
}
