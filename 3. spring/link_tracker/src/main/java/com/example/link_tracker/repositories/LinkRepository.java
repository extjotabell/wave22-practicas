package com.example.link_tracker.repositories;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;

public interface LinkRepository {
    LinkDTO guardar(CreateLinkDTO createLinkDTO);
    LinkDTO getByUrl(String url);

}
