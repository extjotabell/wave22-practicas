package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;

import java.util.Map;

public interface ILinkTrackerRepository {

    Map<Integer, Link> links();

    Link getLinkById(int id);

    int createLink(Link link);

    int getMetric(Link link);

    void updateLink(Link link);

    boolean isValidPassword(String pass, int linkID);
}
