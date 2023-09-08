package com.renzobayarri.blog.repository;

import com.renzobayarri.blog.entity.EntradaBlog;
import com.renzobayarri.blog.exceptions.BlogNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository{

    private List<EntradaBlog> blogEntries;

    public BlogRepositoryImpl() {
        init();
    }

    public List<EntradaBlog> getAll(){
        return blogEntries;
    }

    public EntradaBlog getById(int id) {
        return blogEntries.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EntradaBlog add(EntradaBlog entradaBlog) {

        blogEntries.add(entradaBlog);
        return entradaBlog;
    }

    private void init() {
        blogEntries = new ArrayList<>();
        blogEntries.add(new EntradaBlog(1, "Blog1", "Autor1", LocalDate.of(2023,2,26)));
        blogEntries.add(new EntradaBlog(2, "Blog2", "Autor1", LocalDate.of(2023,3,8)));
        blogEntries.add(new EntradaBlog(3, "Blog3", "Autor2", LocalDate.of(2023,4,17)));
    }

}
