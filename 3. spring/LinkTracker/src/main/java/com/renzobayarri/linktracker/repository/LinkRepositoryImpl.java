package com.renzobayarri.linktracker.repository;

import com.renzobayarri.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    private List<Link> links = new ArrayList<>();

    @Override

    public List<Link> findAll(){
        return links;
    }

    @Override
    public Link findById(int id) {
        return links.stream().filter(l -> l.getLinkId() == id && l.isActive()).findFirst().orElse(null);
    }

    @Override
    public int getNextId(){
        return links.size() + 1;
    }

    @Override
    public Link add(Link link){
        links.add(link);
        return link;
    }

    @Override
    public void inactivate(Link link) {
        link.setActive(false);
    }

    @Override
    public void increaseCounter(Link link) {
        link.setQuantity(link.getQuantity() + 1);
    }

    public Link findByUrl(String url){
        return links.stream().filter(l -> l.getUrl().equals(url) && l.isActive()).findFirst().orElse(null);
    }

}
