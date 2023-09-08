package com.example.ejercicioblog.repository;

import com.example.ejercicioblog.dto.BlogDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository {

    private Map<Integer, BlogDto> dataBase= new HashMap<Integer, BlogDto>();
    @Override
    public List<BlogDto> getAll() {
        return dataBase.values().stream().toList();
    }

    @Override
    public BlogDto getById(Integer id) {
        return dataBase.get(id);
    }


    @Override
    public BlogDto save(BlogDto blogToSave) {
        this.dataBase.put(blogToSave.getId(), blogToSave);
        return null;
    }
}
