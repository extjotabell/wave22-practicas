package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryBlog implements IRepositoryBlog{

    private final List<EntradaBlog> entradaBlogDB;

    public RepositoryBlog() {
        entradaBlogDB = new ArrayList<>();
    }

    @Override
    public void newEntry(EntradaBlog entradaBlog) {
        entradaBlogDB.add(entradaBlog);
    }

    @Override
    public List<EntradaBlog> getAllEntries() {
        return entradaBlogDB;
    }
}
