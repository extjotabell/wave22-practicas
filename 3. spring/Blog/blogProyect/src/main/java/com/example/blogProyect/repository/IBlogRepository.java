package com.example.blogProyect.repository;

import com.example.blogProyect.entity.EntradaBlog;

public interface IBlogRepository {

    EntradaBlog findById(int id);

    void add(EntradaBlog entrada);

}
