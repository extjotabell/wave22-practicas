package com.example.practicaspringblog.service;

import com.example.practicaspringblog.DTO.EntradaBlogDto;
import com.example.practicaspringblog.Exceptions.EntradaBlogExistenteException;
import com.example.practicaspringblog.Exceptions.EntradaBlogNoEncontradaException;
import com.example.practicaspringblog.entity.EntradaBlog;
import com.example.practicaspringblog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public ResponseEntity<String> AgregarEntradaBlog(EntradaBlogDto entradaBlogDto) {
        int id = entradaBlogDto.getId();
        if (blogRepository.existePorId(id)) {
            throw new EntradaBlogExistenteException("Ya existe una entrada de blog con el ID proporcionado");
        }

        EntradaBlog entradaBlog = new EntradaBlog(entradaBlogDto.getId(), entradaBlogDto.getTitulo(), entradaBlogDto.getAutor(),entradaBlogDto.getFechaPublicacion());
        blogRepository.save(entradaBlog);

        return new ResponseEntity<>("Entrada de blog creada correctamente con ID: " + id, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EntradaBlogDto> ObtenerEntradaBlog(int id) {
        Optional<EntradaBlog> entradaBlogOptional = blogRepository.ObtenerPorId(id);

        if (entradaBlogOptional.isEmpty()) {
            throw new EntradaBlogNoEncontradaException("No se encontró una entrada de blog con el Id proporcionado");
        }

        EntradaBlog entradaBlog = entradaBlogOptional.get();
        EntradaBlogDto entradaBlogDto = new EntradaBlogDto(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFechaPublicacion());

        return new ResponseEntity<>(entradaBlogDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EntradaBlogDto>> ObtenerEntradas() {
        List<EntradaBlog> entradas = blogRepository.ObtenerEntradas();
        List<EntradaBlogDto> entradasDTO = entradas.stream()
                .map(this::convertToDto)
                .toList();

        return new ResponseEntity<>(entradasDTO, HttpStatus.OK);
    }

    private EntradaBlogDto convertToDto(EntradaBlog entradaBlog){
        return new EntradaBlogDto(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFechaPublicacion());
    }
}
