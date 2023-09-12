package com.example.blogProyect.service;

import com.example.blogProyect.dtos.EntradaBlogDto;
import com.example.blogProyect.entity.EntradaBlog;
import com.example.blogProyect.repository.BlogRepository;

import java.util.List;

public class BlogService implements IBlogService{

    private BlogRepository blogRepository;

    @Override
    public void add(EntradaBlogDto entradaBlog) {
        EntradaBlog entrada = new EntradaBlog(
                entradaBlog.getIdBlog(),
                entradaBlog.getTitulo(),
                entradaBlog.getAutor(),
                entradaBlog.getFecha()
        );

        blogRepository.add(entrada);
    }
}
