package com.example.blogProyect.repository;

import com.example.blogProyect.dtos.EntradaBlogDto;
import com.example.blogProyect.entity.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


public interface IBlogRepository {

    EntradaBlog findById(int id);
    void add(EntradaBlog entrada);
    List<EntradaBlog> findAll();


}
