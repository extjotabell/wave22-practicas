package com.example.link_tracker.repositories;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import com.example.link_tracker.dto.MetricDTO;

public interface ILinkRepository {
    LinkDTO guardar(CreateLinkDTO createLinkDTO);
    LinkDTO getByUrl(String url);
    LinkDTO getLinkById(Integer linkId);
    LinkDTO updateLink(LinkDTO link);
    void invalidateLink(LinkDTO link);

}
