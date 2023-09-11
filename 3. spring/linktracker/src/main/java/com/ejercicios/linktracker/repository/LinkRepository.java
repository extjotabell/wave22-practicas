package com.ejercicios.linktracker.repository;

import com.ejercicios.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository  implements IRepository<Link, Integer>{

    HashMap<Integer, Link> listaLinks = new HashMap<>();



    @Override
    public Integer save(Link link) {
        listaLinks.put(link.getLinkId(), link);
        return listaLinks.size();
    }

    @Override
    public HashMap<Integer,Link> getAll() {
        return listaLinks;
    }

    @Override
    public Link getById(Integer id) {
        return listaLinks.get(id);
    }

    @Override
    public void delete(Integer id) {

    }
}
