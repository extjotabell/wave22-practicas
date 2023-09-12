package com.example.linkTracker.repository;

import com.example.linkTracker.entity.LinkTracker;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {

    private final HashMap<Integer, LinkTracker> linkTrackerHashMap = new HashMap<>();
    private int nextLinkId = 1;

    public LinkTrackerRepository() {
        // todo data base
    }

    @Override
    public Optional<LinkTracker> findById(Integer linkId) {
        return Optional.ofNullable(linkTrackerHashMap.get(linkId));
    }

    @Override
    public Integer save(LinkTracker linkTracker) {
        linkTracker.setId(nextLinkId++);
        linkTrackerHashMap.put(linkTracker.getId(), linkTracker);
        return linkTracker.getId();
    }

    @Override
    public boolean existePorId(int id) {
        return linkTrackerHashMap.containsKey(id);
    }

    @Override
    public void invalidateLink(Integer linkId) {
        LinkTracker link = linkTrackerHashMap.get(linkId);
        if (link != null) {
            link.setInvalidate(!link.isInvalidate());
            update(link);
        }
    }

    @Override
    public void update(LinkTracker link) {
        linkTrackerHashMap.replace(link.getId(), link);
    }
}
