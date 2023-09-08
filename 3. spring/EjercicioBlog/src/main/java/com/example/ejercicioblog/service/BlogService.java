package com.example.ejercicioblog.service;

import com.example.ejercicioblog.dto.BlogDto;
import com.example.ejercicioblog.exception.BadRequestException;
import com.example.ejercicioblog.exception.NotFoundException;
import com.example.ejercicioblog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository repository;

    @Override
    public Integer saveBlog(BlogDto blogDto) {
        List<BlogDto> existentBlogs = repository.getAll();
        if (existentBlogs.contains(blogDto)){
            throw new BadRequestException("Blog ya existente!");
        };
        repository.save(blogDto);
        return null;
    }

    @Override
    public BlogDto getById(Integer id) {
        BlogDto blog = repository.getById(id);
        if (blog == null){
            throw new NotFoundException("Blog inexistente!");
        }
        return blog;
    }

    @Override
    public List<BlogDto> getAll() {
        return repository.getAll();
    }
}
