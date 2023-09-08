package com.example.blog.service;

import com.example.blog.dto.CrearEntradaBlogDTO;
import com.example.blog.exception.BlogNotFound;
import com.example.blog.exception.DuplicatedIdException;
import com.example.blog.exception.NoBlogsCreated;
import com.example.blog.model.EntradaBlog;
import com.example.blog.repository.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Integer addBlog(CrearEntradaBlogDTO entradaBlog) {
        EntradaBlog eb = new ModelMapper().map(entradaBlog, EntradaBlog.class);
        Integer createdId = blogRepository.createBlog(eb);

        if(createdId == null){
            throw new DuplicatedIdException("Id incorrecto/duplicado");
        }

        return createdId;
    }


    public CrearEntradaBlogDTO getBlog(Integer id) {
        EntradaBlog entradaBlog = this.blogRepository.getBlog(id);

        if(entradaBlog == null){
            throw new BlogNotFound("No se encuentra dicho blog con el id proporcionado");
        }

        return new ModelMapper().map(entradaBlog, CrearEntradaBlogDTO.class);
    }

    public List<CrearEntradaBlogDTO> getAll() {
        List<EntradaBlog> entradaBlogs = this.blogRepository.getAll();

        if(entradaBlogs.isEmpty()){
            throw new NoBlogsCreated("No se encontaron blogs creados.");
        }

        return entradaBlogs.stream().map(b-> new ModelMapper().map(b, CrearEntradaBlogDTO.class)).toList();
    }
}
