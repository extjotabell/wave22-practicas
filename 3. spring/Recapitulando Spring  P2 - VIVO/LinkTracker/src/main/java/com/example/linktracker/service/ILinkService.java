package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDTO;

public interface ILinkService {
    String getUrlLinkById(int id);
    int createLink(LinkDTO linkDTO);
    int getMetric(int linkID);

    void invalidateLink(int linkId);

    boolean isValidLink(int linkId);

    void increaseRedirectAmount(int linkId);

    boolean isValidPassword(String pass, int linkID);
}
