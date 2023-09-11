package com.example.LinkTracker.repository;

import com.example.LinkTracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{
    private Map<Integer, Link> links;

    public LinkRepository() {
        this.links = new HashMap<>();
    }

    @Override
    public Integer createNewLink(Link link) {
        int id = links.size()+1;
        link.setId(id);
        links.put(id,link);
        return id;
    }

    @Override
    public void addVisit(Integer id) {
        Link link = links.get(id);
        link.setVisits(link.getVisits()+1);
    }

    @Override
    public int getVisits(Integer id) {
        return links.get(id).getVisits();
    }

    @Override
    public void invalidateLink(Integer id) {
        Link link = links.get(id);
        link.setActive(false);

    }

    @Override
    public Link getLink(Integer id) {
        return links.get(id);
    }
}
