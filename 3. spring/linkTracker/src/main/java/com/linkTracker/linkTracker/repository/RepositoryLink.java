package com.linkTracker.linkTracker.repository;

import com.linkTracker.linkTracker.entity.Link;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryLink implements IRepositoryLink{

    private List<Link> linksDB;

    public RepositoryLink() {
        linksDB = new ArrayList<>();
    }

    @Override
    public void createLink(Link link) {
        linksDB.add(link);
    }

    @Override
    public int getLinkAmount() {
        return linksDB.size();
    }

    @Override
    public List<Link> getAllLinks() {
        return linksDB;
    }

    @Override
    public void addVisit(Link link) {
        linksDB.get(linksDB.indexOf(link)).setRedirectCount(linksDB.get(linksDB.indexOf(link)).getRedirectCount() + 1);
    }

    @Override
    public void invalidateLink(Link link) {
        linksDB.get(linksDB.indexOf(link)).set_valid(false);
    }

}
