package com.example.ejerciciolinktracker.service;

import com.example.ejerciciolinktracker.dto.LinkDTO;
import com.example.ejerciciolinktracker.dto.LinkRequestDTO;
import com.example.ejerciciolinktracker.entity.Link;
import com.example.ejerciciolinktracker.controller.exception.NotFoundException;
import com.example.ejerciciolinktracker.repository.LinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    @Autowired
    LinkRepository linkRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public int guardarLink(LinkRequestDTO link) {
        return linkRepository.guardarLink(link.getUrl(), link.getPassword());
    }

    @Override
    public LinkDTO getLink(int id, String password) {
        Link link = linkRepository.getLink(id, password);
        if(link == null || !link.isActivo())
            throw new NotFoundException("No se ha encontrado el link con el id "+id);
        linkRepository.sumarContador(id);
        return mapper.convertValue(link, LinkDTO.class);
    }

    @Override
    public int getRedirecciones(int id) {
        int contador = linkRepository.getRedirecciones(id);
        if(contador == -1)
            throw new NotFoundException("No se ha encontrado el link con el id "+id);
        else
            return contador;
    }

    @Override
    public void invalidarLink(int id) {
        boolean inv = linkRepository.invalidarLink(id);
        if(!inv)
            throw new NotFoundException("No se ha encontrado el link con el id "+id);
    }
}
