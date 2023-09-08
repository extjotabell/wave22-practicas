package com.nicolassalvo.blog.service;

import com.nicolassalvo.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    BlogDTO add(BlogDTO blog);
    BlogDTO getById(int id);
    List<BlogDTO> getall();
}
