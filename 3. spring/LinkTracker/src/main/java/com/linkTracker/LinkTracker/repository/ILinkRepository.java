package com.linkTracker.LinkTracker.repository;

import com.linkTracker.LinkTracker.entity.Link;

public interface ILinkRepository {
    Link saveLink(String url, int pass);
    Link findById(int id);
    int metrics(int id);
    void invalidate(int id);
    void sumCount(int id);
}
