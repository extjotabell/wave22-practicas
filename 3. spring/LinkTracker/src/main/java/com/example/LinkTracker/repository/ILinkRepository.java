package com.example.LinkTracker.repository;

import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.model.Link;

public interface ILinkRepository {
    Integer createNewLink(Link link);
    void addVisit(Integer id);
    int getVisits(Integer id);
    void invalidateLink(Integer id);
    Link getLink(Integer id);
}
