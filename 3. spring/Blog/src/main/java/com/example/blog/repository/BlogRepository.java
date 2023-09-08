package com.example.blog.repository;

import com.example.blog.exception.DuplicatedIdException;
import com.example.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository {
    private final HashMap<Integer, EntradaBlog> entradaBlogHashMap;

    public BlogRepository() {
        this.entradaBlogHashMap = new HashMap<>();
    }

    public Integer createBlog(EntradaBlog entradaBlog){
        if(this.entradaBlogHashMap.containsKey(entradaBlog.getId())) {
            return null;
        }

        this.entradaBlogHashMap.put(entradaBlog.getId(), entradaBlog);

        return entradaBlog.getId();
    }

    public EntradaBlog getBlog(Integer id) {
        return this.entradaBlogHashMap.get(id);
    }

    public List<EntradaBlog> getAll() {
        return this.entradaBlogHashMap.values().stream().toList();
    }
}
