package com.example.ejerciciolinktracker.repository;

import com.example.ejerciciolinktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {

    private List<Link> database;
    private int contadorId;

    public LinkRepository(List<Link> database) {
        this.database = database;
        this.contadorId = 0;
    }

    @Override
    public int guardarLink(String url, String password) {
        contadorId++;
        Link link = new Link(contadorId, url,0, password, true);
        database.add((link));
        return link.getId();
    }

    @Override
    public Link getLink(int id) {
        return database.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public Link getLink(int id, String password) {
        return database.stream().filter(l -> l.getId() == id && l.getPassword().equals(password)).findFirst().orElse(null);
    }

    @Override
    public int getRedirecciones(int id) {
       Link link = getLink(id);
       if(link == null)
           return -1;
       else
           return link.getContador();
    }

    @Override
    public boolean invalidarLink(int id) {
        Link link = getLink(id);
        if(link == null)
            return false;
        else {
            link.setActivo(false);
            return true;
        }
    }

    @Override
    public void sumarContador(int id) {
        Link link = getLink(id);
        link.setContador(link.getContador() +1);
    }
}
