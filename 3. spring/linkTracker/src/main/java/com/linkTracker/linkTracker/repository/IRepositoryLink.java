package com.linkTracker.linkTracker.repository;

import com.linkTracker.linkTracker.dto.LinkIdDto;
import com.linkTracker.linkTracker.entity.Link;

import java.util.List;

public interface IRepositoryLink {
    void createLink(Link link);
    int getLinkAmount();
    List<Link> getAllLinks();
    void addVisit(Link link);
    void invalidateLink(Link link);
}
