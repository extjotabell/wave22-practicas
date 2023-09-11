package com.linkTracker.LinkTracker.service;

import com.linkTracker.LinkTracker.dtos.LinkDTO;
import com.linkTracker.LinkTracker.entity.Link;
import com.linkTracker.LinkTracker.exceptions.NotActiveUrl;
import com.linkTracker.LinkTracker.exceptions.NotPermission;
import com.linkTracker.LinkTracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements ILinkService{

    @Autowired
    ILinkRepository repo;

    @Override
    public LinkDTO saveLink(LinkDTO link) {
        Link newLink = repo.saveLink(link.getUrl(), link.getPass());
        return new LinkDTO(newLink.getUrl(),newLink.getId(),newLink.getCount(),newLink.getPass(),true);
    }

    @Override
    public LinkDTO findById(int id, int pass) {
        Link link = repo.findById(id);
        if(!link.isActive()){
            throw new NotActiveUrl("Url no encontrada");
        }
        if(link.getPass() != pass){
            throw new NotPermission("Pass incorrecta");
        }
        return new LinkDTO(link.getUrl(),link.getId(),link.getCount(),link.getPass(),link.isActive());
    }

    @Override
    public int metrics(int id) {
        return repo.metrics(id);
    }

    @Override
    public void invalidate(int id) {
        repo.invalidate(id);
    }

    @Override
    public void sumCount(int id) {
        repo.sumCount(id);
    }

}
