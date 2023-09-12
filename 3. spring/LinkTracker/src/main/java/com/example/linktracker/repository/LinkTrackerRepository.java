package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import com.example.linktracker.exception.LinkBadRequestException;
import com.example.linktracker.exception.LinkNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkTrackerRepository implements ILinkTrackerRepository {

    Map<Integer, Link> links;

    public LinkTrackerRepository() {
        links = new HashMap<>();
    }

    @Override
    public Map<Integer, Link> links() {
        return links;
    }

    @Override
    public Link getLinkById(int id) {
        if (!links.containsKey(id)) {
            throw new LinkNotFoundException(String.format("No se encontró el id: %d", id));
        }
        return links.get(id);
    }

    @Override
    public int createLink(Link link) {
        int linkId = link.getId();
        if (links.containsKey(linkId)) {
            throw new LinkBadRequestException(String.format("Id ya existente: %d", linkId));
        }
        links.put(link.getId(), link);
        return link.getId();
    }

    @Override
    public int getMetric(Link link) {
        validateLink(link.getId());
        return links.get(link.getId()).getRedirectionCount();
    }

    @Override
    public void updateLink(Link link) {
        validateLink(link.getId());
        links.put(link.getId(), link);
    }

    private void validateLink(int linkId) {
        if (!links.containsKey(linkId)) {
            throw new LinkNotFoundException(String.format("No se encontró el id: %d", linkId));
        }
    }

    @Override
    public boolean isValidPassword(String pass, int linkID){
        return links.get(linkID).getPassword().equals(pass);
    }
}
