package com.ejercicios.linktracker.service;

import com.ejercicios.linktracker.dto.LinkDTO;
import com.ejercicios.linktracker.entity.Link;
import com.ejercicios.linktracker.exception.NotFoundException;
import com.ejercicios.linktracker.repository.IRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LinkService implements IService<LinkDTO,Integer> {

    @Autowired
    IRepository<Link, Integer> repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Integer save(LinkDTO linkDTO) {
        Link link = mapper.convertValue(linkDTO, Link.class);
        link.setCount(0);
        link.setIsActive(true);
        return repository.save(link);
    }

    @Override
    public HashMap<Integer, LinkDTO> getAll() {
        HashMap<Integer, Link> links = repository.getAll();

        // Convierte el HashMap de Link a un HashMap de LinkDTO usando un mapeo
        HashMap<Integer, LinkDTO> linksDTO = new HashMap<>();

        for (Integer key : links.keySet()) {
            Link link = links.get(key);
            LinkDTO linkDTO = convertToDTO(link);
            linksDTO.put(key, linkDTO);
        }

        return linksDTO;
    }

    private LinkDTO convertToDTO(Link link) {
        // Utiliza ObjectMapper para convertir un objeto Link a LinkDTO
        return mapper.convertValue(link, LinkDTO.class);
    }

    @Override
    public LinkDTO getById(Integer id) {
        Link link = repository.getById(id);
        if (link.getIsActive()){
            LinkDTO linkDTO = new LinkDTO(link.getLinkId(), link.getUrl(), link.getCount(), link.getPassword());
            return linkDTO;
        }else{
            throw new NotFoundException("El link no esta activo");
        }
    }

    @Override
    public String findUrlById(Integer id) {
        Link link = repository.getById(id);
        LinkDTO linkDTO = new LinkDTO(link.getLinkId(), link.getUrl(), link.getCount(), link.getPassword());
        return linkDTO.getUrl();
    }
    @Override
    public void delete(Integer id) {

    }

    @Override
    public void countRedirect(LinkDTO link){
        repository.getById(link.getLinkId()).setCount(link.getCount()+1);
    }

    @Override
    public void invalidarLink(LinkDTO link){
        repository.getById(link.getLinkId()).setIsActive(false);
    }

    @Override
    public boolean validarPassword(LinkDTO linkDTO, String Password){
        Link link = repository.getById(linkDTO.getLinkId());
        if(link.getPassword().equalsIgnoreCase(Password)){
            return true;
        }else{
            return false;
        }
    }

}
