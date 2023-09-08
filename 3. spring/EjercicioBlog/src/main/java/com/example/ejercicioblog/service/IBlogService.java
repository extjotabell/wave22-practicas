package com.example.ejercicioblog.service;

import com.example.ejercicioblog.dto.BlogDto;

import java.util.List;

public interface IBlogService {

    Integer saveBlog(BlogDto blogDto);
    BlogDto getById(Integer id);
    List<BlogDto> getAll();

}
