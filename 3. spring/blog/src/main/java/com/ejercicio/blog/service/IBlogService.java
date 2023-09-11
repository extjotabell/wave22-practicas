package com.ejercicio.blog.service;

import com.ejercicio.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {

    Integer saveBlog(BlogDTO blogDTO);
    BlogDTO getById(Integer id);
    List<BlogDTO> getAll();
}
