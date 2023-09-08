package com.introduccionspring.blog.repositories;

import com.introduccionspring.blog.entities.EntradaBlog;

import java.util.List;

public interface EntradaBlogRepository {
    void addBlog(EntradaBlog blog);
    EntradaBlog getById(Long id);
    List<EntradaBlog> getAll();
}
