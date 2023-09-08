package com.renzobayarri.blog.repository;

import com.renzobayarri.blog.entity.EntradaBlog;
import com.renzobayarri.blog.exceptions.BlogNotFoundException;

import java.util.List;

public interface BlogRepository {

    List<EntradaBlog> getAll();

    EntradaBlog getById(int id);

    EntradaBlog add(EntradaBlog entradaBlog);
}
