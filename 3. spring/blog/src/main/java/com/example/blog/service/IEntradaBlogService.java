package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEntradaBlogService {
    List<EntradaBlogDTO> getAllEntradaBlog();
    EntradaBlogDTO getEntradaBlogById(int id);

    void crearEntrada(EntradaBlogDTO entradaBlogDTO);
}
