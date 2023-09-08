package com.introduccionspring.blog.services;

import com.introduccionspring.blog.entities.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface EntradaBlogService {
    void addBlog(EntradaBlog blog);
    EntradaBlog getBlogById(Long id);
    List<EntradaBlog> getAllBlogs();
}
