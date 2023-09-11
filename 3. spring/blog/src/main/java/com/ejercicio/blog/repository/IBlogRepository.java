package com.ejercicio.blog.repository;

import com.ejercicio.blog.dto.BlogDTO;

import java.util.List;


public interface IBlogRepository {

    List<BlogDTO> getAll();
    BlogDTO getById(Integer id);
    BlogDTO save(BlogDTO blogDTOsave);
}
