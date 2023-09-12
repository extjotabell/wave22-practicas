package com.example.blogProyect.repository;

import com.example.blogProyect.entity.EntradaBlog;

import java.util.List;

public class BlogRepository  implements IBlogRepository{

    List<EntradaBlog> dataBase;

    @Override
    public EntradaBlog findById(int id) {
        return null;
    }

    @Override
    public void add(EntradaBlog entrada) {
        dataBase.add(entrada);
    }


}
