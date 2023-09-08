package com.example.practicaspringblog.service;

import com.example.practicaspringblog.DTO.EntradaBlogDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogService {
    ResponseEntity<String> AgregarEntradaBlog(EntradaBlogDto entradaBlogDto);
    ResponseEntity<EntradaBlogDto> ObtenerEntradaBlog(int id);
    ResponseEntity<List<EntradaBlogDto>> ObtenerEntradas();
}
