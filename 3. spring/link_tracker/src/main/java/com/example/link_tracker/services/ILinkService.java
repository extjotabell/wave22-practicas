package com.example.link_tracker.services;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.InvalidateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import com.example.link_tracker.dto.MetricDTO;

public interface ILinkService {
     LinkDTO createLink(CreateLinkDTO linkUrl);
     MetricDTO getLinkMetrics(Integer linkId);
     String redirect(Integer linkId, String password);
     void invalidateLink(Integer linkId);
     //void validateURL();
}
