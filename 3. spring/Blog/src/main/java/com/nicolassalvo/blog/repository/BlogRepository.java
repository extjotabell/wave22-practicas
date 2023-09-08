package com.nicolassalvo.blog.repository;

import com.nicolassalvo.blog.entity.EntradaBlog;

import java.util.List;

public interface BlogRepository {

    List<EntradaBlog> getAll();

    EntradaBlog getById(int id);

    EntradaBlog add(EntradaBlog entradaBlog);
}
