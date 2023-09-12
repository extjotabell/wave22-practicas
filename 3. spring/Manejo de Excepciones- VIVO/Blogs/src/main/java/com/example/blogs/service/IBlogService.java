package com.example.blogs.service;

import com.example.blogs.dto.BlogDTO;
import java.util.List;

public interface IBlogService {

    String crearEntrada(BlogDTO blogDTO);

    BlogDTO getBlogDTOByID(int id);

    List<BlogDTO> getAllEntradasBlog();
}
