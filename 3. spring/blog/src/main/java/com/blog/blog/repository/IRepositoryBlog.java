package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;

import java.util.List;

public interface IRepositoryBlog {

    void newEntry(EntradaBlog entradaBlog);
    List<EntradaBlog> getAllEntries();
}
