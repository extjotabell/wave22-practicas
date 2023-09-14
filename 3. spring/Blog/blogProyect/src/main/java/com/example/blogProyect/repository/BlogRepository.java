package com.example.blogProyect.repository;

import com.example.blogProyect.dtos.EntradaBlogDto;
import com.example.blogProyect.entity.EntradaBlog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BlogRepository  implements IBlogRepository{

    List<EntradaBlog> dataBase;

    @Override
    public EntradaBlog findById(int id) {
        return dataBase.stream().filter(x->x.getIdBlog()==id).findFirst().orElse(null);
    }

    @Override
    public void add(EntradaBlog entrada) {
        dataBase.add(entrada);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return dataBase;
    }


}
