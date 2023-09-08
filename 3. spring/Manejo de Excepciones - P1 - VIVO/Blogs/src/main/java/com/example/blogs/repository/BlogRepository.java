package com.example.blogs.repository;

import com.example.blogs.entity.EntradaBlog;
import com.example.blogs.exception.BlogConflictException;
import com.example.blogs.exception.BlogNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {

    // Simula nuestra base de datos
    private HashMap<Integer, EntradaBlog> entradasBlog;

    public BlogRepository() {
        entradasBlog = new HashMap<>();
    }

    @Override
    public String createEntrada(EntradaBlog entradaBlog) {
        int blogId = entradaBlog.getId();
        if (entradasBlog.containsKey(blogId)) {
            throw new BlogConflictException(String.format("Ya existe una entrada con el id: %d", blogId));
        }

        entradasBlog.put(blogId, entradaBlog);
        return String.format("Entrada creada exitosamente con id: %d", blogId);
    }

    @Override
    public EntradaBlog getEntradaBlogById(int id){

        if (!entradasBlog.containsKey(id)) {
            throw new BlogNotFoundException(String.format("No se encontro el id: %d", id));
        }
        return entradasBlog.get(id);
    }

    @Override
    public List<EntradaBlog> getAllEntradasBlog(){
        // Aca no hay error que manejar
        return entradasBlog.values().stream().toList();
    }

}
