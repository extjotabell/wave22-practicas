package com.example.ejerciciolinktracker.service;

import com.example.ejerciciolinktracker.dto.LinkDTO;
import com.example.ejerciciolinktracker.dto.LinkRequestDTO;

public interface ILinkService {

    int guardarLink(LinkRequestDTO linkRequestDTO);
    LinkDTO getLink(int id, String password);
    int getRedirecciones(int id);
    void invalidarLink(int id);
}
