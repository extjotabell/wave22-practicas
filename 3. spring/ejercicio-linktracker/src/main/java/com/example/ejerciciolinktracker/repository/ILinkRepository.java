package com.example.ejerciciolinktracker.repository;

import com.example.ejerciciolinktracker.entity.Link;

public interface ILinkRepository {

    int guardarLink(String url, String password);
    Link getLink(int id);
    Link getLink(int id, String password);
    int getRedirecciones(int id);
    boolean invalidarLink(int id);

    void sumarContador(int id);

}
