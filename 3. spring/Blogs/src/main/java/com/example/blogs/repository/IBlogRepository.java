package com.example.blogs.repository;

import com.example.blogs.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    String createEntrada(EntradaBlog entradaBlog);
    EntradaBlog getEntradaBlogById(int id);
    List<EntradaBlog> getAllEntradasBlog();

}
