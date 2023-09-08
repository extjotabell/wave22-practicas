package com.introduccionspring.blog.repositories.impl;

import com.introduccionspring.blog.entities.EntradaBlog;
import com.introduccionspring.blog.repositories.EntradaBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EntradaBlogRepositoryImpl implements EntradaBlogRepository {

    List<EntradaBlog> entradasBlog;

    public EntradaBlogRepositoryImpl() {
        entradasBlog = new ArrayList<>();
    }
    @Override
    public void addBlog(EntradaBlog blog) {
        entradasBlog.add(blog);
    }

    @Override
    public EntradaBlog getById(Long id) {
        EntradaBlog entradaBlogEncontrada = null;
        for (EntradaBlog e: entradasBlog) {
            if (Objects.equals(e.getId(), id)) {
                entradaBlogEncontrada = e;
            }
        }
        return entradaBlogEncontrada;
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradasBlog;
    }
}
