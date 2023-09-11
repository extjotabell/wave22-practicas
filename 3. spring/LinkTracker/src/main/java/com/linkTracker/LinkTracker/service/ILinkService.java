package com.linkTracker.LinkTracker.service;

import com.linkTracker.LinkTracker.dtos.LinkDTO;

public interface ILinkService {
    LinkDTO saveLink(LinkDTO link);
    LinkDTO findById(int id, int pass);
    int metrics(int id);
    void invalidate(int id);
    void sumCount ( int id);

}
