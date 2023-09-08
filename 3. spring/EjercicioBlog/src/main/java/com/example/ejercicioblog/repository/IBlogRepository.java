package com.example.ejercicioblog.repository;
import com.example.ejercicioblog.dto.BlogDto;

import java.util.List;

public interface IBlogRepository {

    List<BlogDto> getAll();
    BlogDto getById(Integer id);
    BlogDto save(BlogDto blogToSave);
}
