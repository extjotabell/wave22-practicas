package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.CreateLinkDTO;
import com.example.LinkTracker.dto.LinkDTO;

public interface ILinkService {
    Integer createNewLink(CreateLinkDTO linkDTO);
    void addVisit(Integer id);
    int getVisits(Integer id);
    void invalidateLink(Integer id);
    LinkDTO redirect(Integer id, String password);
}
