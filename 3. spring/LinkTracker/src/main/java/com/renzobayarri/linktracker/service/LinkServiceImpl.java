package com.renzobayarri.linktracker.service;

import com.renzobayarri.linktracker.dto.LinkDTO;
import com.renzobayarri.linktracker.dto.LinkRequestDto;
import com.renzobayarri.linktracker.entity.Link;
import com.renzobayarri.linktracker.exceptions.IncorrectPasswordException;
import com.renzobayarri.linktracker.exceptions.LinkNotFoundException;
import com.renzobayarri.linktracker.repository.LinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService {

    private LinkRepository linkRepository;

    @Override
    public Link findById(int id) {
        Link link = linkRepository.findById(id);
        if (link == null) {
            throw new LinkNotFoundException(id);
        }
        return link;
    }

    @Override
    public LinkDTO add(LinkRequestDto linkRequestDto) {
        Link link = new Link(linkRepository.getNextId(), linkRequestDto.getUrl().trim(), 0, true, linkRequestDto.getPassword());
        linkRepository.add(link);
        return new LinkDTO(link.getLinkId());
    }

    @Override
    public void inactivate(int id) {
        Link link = findById(id);
        linkRepository.inactivate(link);
    }

    @Override
    public void increaseCounter(int id) {
        Link link = findById(id);
        linkRepository.increaseCounter(link);
    }

    @Override
    public String getUrl(int id, String password) {
        Link link = findById(id);
        if (password.equals(link.getPassword())) {
            return link.getUrl();
        } else {
            throw new IncorrectPasswordException();
        }
    }

    public int getQuantity(int id) {
        Link link = findById(id);
        return link.getQuantity();
    }

    public boolean validarUrl(String url) {
        if (linkRepository.findByUrl(url) != null) {
            return true;
        }
        throw new RuntimeException("Url no válida");
    }
}
