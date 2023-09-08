package com.example.practicaspringblog.repository;

import com.example.practicaspringblog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Optional<EntradaBlog> ObtenerPorId(int id);
    List<EntradaBlog> ObtenerEntradas();
    void save(EntradaBlog entradaBlog);
    boolean existePorId(int id);
}
