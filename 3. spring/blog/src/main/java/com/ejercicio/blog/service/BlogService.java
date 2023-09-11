package com.ejercicio.blog.service;

import com.ejercicio.blog.dto.BlogDTO;
import com.ejercicio.blog.exception.BadRequestException;
import com.ejercicio.blog.exception.NotFoundException;
import com.ejercicio.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository repository;
    @Override
    public Integer saveBlog(BlogDTO blogDTO) {
        List<BlogDTO> existenBlogs = repository.getAll();
        if(existenBlogs.contains(blogDTO)){
            throw new BadRequestException("Blog ya existente!");
        };
        repository.save(blogDTO);
        return null;
    }

    @Override
    public BlogDTO getById(Integer id) {
        BlogDTO blog = repository.getById(id);
        if(blog == null){
            throw new NotFoundException(("Blog Inexistente"));
        }
        return null;
    }

    @Override
    public List<BlogDTO> getAll() {
        return repository.getAll();
    }
}
