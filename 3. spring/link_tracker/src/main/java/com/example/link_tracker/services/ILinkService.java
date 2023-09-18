package com.example.link_tracker.services;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.InvalidateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;

public interface ILinkService {
     LinkDTO createLink(CreateLinkDTO linkUrl);
     LinkDTO getLinkMetrics(Integer linkId);
     void redirect(Integer linkId);
     void invalidateLink(InvalidateLinkDTO invalidateLinkDTO);
     //void validateURL();
}
