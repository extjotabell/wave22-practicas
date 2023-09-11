package com.linkTracker.LinkTracker.repository;

import com.linkTracker.LinkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepositoryImp implements ILinkRepository{

    private List<Link> links = new ArrayList<>();
    private int id;

    public LinkRepositoryImp(List<Link> links) {
        this.links = links;
        this.id = 0;
    }

    @Override
    public Link saveLink(String url, int pass) {
        Link link = new Link(id,url,0,pass,true);
        links.add(link);
        id++;
        return link;
    }

    @Override
    public Link findById(int id) {
        return links.stream().filter(l-> l.getId() == id).findFirst().orElse(null);
    }

    @Override
    public int metrics(int id) {
        return findById(id).getCount();
    }

    @Override
    public void invalidate(int id) {
        findById(id).setActive(false);
    }

    @Override
    public void sumCount(int id) {
        Link link = findById(id);
        link.setCount(link.getCount() + 1);
    }
}
