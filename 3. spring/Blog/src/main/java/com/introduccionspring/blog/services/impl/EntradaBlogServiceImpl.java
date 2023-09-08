package com.introduccionspring.blog.services.impl;

import com.introduccionspring.blog.entities.EntradaBlog;
import com.introduccionspring.blog.exceptions.EntradaBlogNotFoundException;
import com.introduccionspring.blog.exceptions.IdAlreadyTakenException;
import com.introduccionspring.blog.repositories.EntradaBlogRepository;
import com.introduccionspring.blog.services.EntradaBlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntradaBlogServiceImpl implements EntradaBlogService {

    private final EntradaBlogRepository entradaBlogRepository;
    @Override
    public void addBlog(EntradaBlog blog) {
        ensureUniqueId(blog.getId());
        entradaBlogRepository.addBlog(blog);
    }
    @Override
    public EntradaBlog getBlogById(Long id) {
        EntradaBlog entradaBlogEncontrada = entradaBlogRepository.getById(id);
        if (entradaBlogEncontrada == null) {
            throw new EntradaBlogNotFoundException();
        }
        return entradaBlogEncontrada;
    }
    @Override
    public List<EntradaBlog> getAllBlogs() {
        return entradaBlogRepository.getAll();
    }

    private void ensureUniqueId(Long id) {
        for (EntradaBlog e : getAllBlogs()) {
            if(Objects.equals(e.getId(), id)) {
                throw new IdAlreadyTakenException();
            }
        }
    }
}
