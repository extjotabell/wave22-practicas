package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    public List<EntradaBlogDTO> getAllEntradaBlog() {
        return null;
    }
    public EntradaBlogDTO getEntradaBlogById(int id) {
        return null;
    }

    @Override
    public void crearEntrada(EntradaBlogDTO entradaBlogDTO) {

    }
}
