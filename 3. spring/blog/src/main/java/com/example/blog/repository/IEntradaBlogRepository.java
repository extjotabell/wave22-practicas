package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    Integer save(EntradaBlog entradaBlog);

    EntradaBlog get(Integer id);

    List<EntradaBlog> getAll();
}
