package com.renzobayarri.blog.service;

import com.renzobayarri.blog.dto.BlogDTO;
import com.renzobayarri.blog.repository.BlogRepository;

import java.util.List;

public interface IBlogService {
    BlogDTO add(BlogDTO blog);
    BlogDTO getById(int id);
    List<BlogDTO> getall();
}
