package com.example.blog.repository;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface IBlogRepository {

    List<EntradaBlog> getBlogInformation();

    void crearBlog(EntradaBlogDTO entradaBlogDTO);
}
