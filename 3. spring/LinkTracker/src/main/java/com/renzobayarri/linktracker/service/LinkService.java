package com.renzobayarri.linktracker.service;

import com.renzobayarri.linktracker.dto.LinkDTO;
import com.renzobayarri.linktracker.dto.LinkRequestDto;
import com.renzobayarri.linktracker.entity.Link;

public interface LinkService {

    Link findById(int id);
    LinkDTO add(LinkRequestDto linkRequestDto);

    void inactivate(int id);

    void increaseCounter(int id);

    String getUrl(int id, String password);

    int getQuantity(int id);

    boolean validarUrl(String url);

}
