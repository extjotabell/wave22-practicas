package com.example.blog.repository;

import com.example.blog.dto.EntradaBlogDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
public class BlogRepository implements IBlogRepository{

    private HashMap<Integer, EntradaBlogDTO> data = new HashMap<>();


    public BlogRepository() {
        this.data = loadDataBase();
    }

    HashMap<Integer, EntradaBlogDTO> loadDataBase(){
        HashMap<Integer, EntradaBlogDTO> newDatabase = new HashMap<>();
        EntradaBlogDTO entrada = new EntradaBlogDTO(1, "Sueñan los androides con ovejas electricas?", "Lupe", "10-10-1950");
        newDatabase.put(entrada.getId(), entrada);
        return newDatabase;
    }

    @Override
    public HashMap<EntradaBlogDTO> getBlogInformation() {
        return this.data;
    }

    @Override
    public void crearBlog(EntradaBlogDTO entradaBlogDTO) {
        data.get(entradaBlogDTO.getId());
    }
}
