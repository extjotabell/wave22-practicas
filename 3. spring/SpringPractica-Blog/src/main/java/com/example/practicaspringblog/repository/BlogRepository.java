package com.example.practicaspringblog.repository;

import com.example.practicaspringblog.DTO.EntradaBlogDto;
import com.example.practicaspringblog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepository implements IBlogRepository{
    private final Map<Integer, EntradaBlog> blogData = new HashMap<>();
    private int nextId = 1;

    public BlogRepository(){
        agregarEntradasBlog(new EntradaBlog(nextId++, "Titulo1", "Autor1", new Date()));
        agregarEntradasBlog(new EntradaBlog(nextId++, "Titulo2", "Autor2", new Date()));
        agregarEntradasBlog(new EntradaBlog(nextId++, "Titulo3", "Autor3", new Date()));
    }

    @Override
    public Optional<EntradaBlog> ObtenerPorId(int id) {
        return Optional.ofNullable(blogData.get(id));
    }

    @Override
    public List<EntradaBlog> ObtenerEntradas() {
        return new ArrayList<>(blogData.values());
    }

    @Override
    public void save(EntradaBlog entradaBlog) {
        blogData.put(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public boolean existePorId(int id) {
        return blogData.containsKey(id);
    }

    private void agregarEntradasBlog(EntradaBlog entradaBlog){
        blogData.put(entradaBlog.getId(), entradaBlog);
    }
}
