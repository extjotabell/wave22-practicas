package com.ejercicio.blog.repository;

import com.ejercicio.blog.dto.BlogDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository {

    private Map<Integer, BlogDTO> dataBase = new HashMap<Integer,BlogDTO>();

    @Override
    public List<BlogDTO> getAll() {
        return dataBase.values().stream().toList();
    }

    @Override
    public BlogDTO getById(Integer id) {
        return dataBase.get(id);
    }

    @Override
    public BlogDTO save(BlogDTO blogDTOsave) {
        this.dataBase.put(blogDTOsave.getId(), blogDTOsave);
        return null;
    }
}
