package com.renzobayarri.linktracker.repository;

import com.renzobayarri.linktracker.entity.Link;

import java.util.List;

public interface LinkRepository {

    List<Link> findAll();

    Link findById(int id);

    int getNextId();

    Link add(Link link);

    void inactivate(Link link);

    void increaseCounter(Link link);

    Link findByUrl(String url);


}
