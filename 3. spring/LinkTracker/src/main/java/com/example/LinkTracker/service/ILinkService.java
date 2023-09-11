package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.model.Link;

public interface ILinkService {
    Integer createNewLink(LinkDTO linkDTO);
    void addVisit(Integer id);
    int getVisits(Integer id);
    void invalidateLink(Integer id);
    LinkDTO redirect(Integer id);
}
