package com.introduccionspring.blog.web.controllers;

import com.introduccionspring.blog.entities.EntradaBlog;
import com.introduccionspring.blog.services.EntradaBlogService;
import com.introduccionspring.blog.web.dto.EntradaBlogDTO;
import com.introduccionspring.blog.web.mappers.EntradaBlogMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EntradaBlogController {

    private final EntradaBlogService entradaBlogService;
    private final EntradaBlogMapper  entradaBlogMapper;

    @PostMapping("/blog")
    ResponseEntity<String> createEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog = entradaBlogMapper.toEntity(entradaBlogDTO);
        entradaBlogService.addBlog(entradaBlog);
        return ResponseEntity.ok("El blog se ha creado exitosamente " + entradaBlogDTO.getId());
    }

    @GetMapping("blog/{id}")
    ResponseEntity<EntradaBlogDTO> getEntradaBlog(@PathVariable Long id) {
        EntradaBlog entradaBlog = entradaBlogService.getBlogById(id);
        return ResponseEntity.ok(entradaBlogMapper.toDto(entradaBlog));
    }
    @GetMapping("/blogs")
    ResponseEntity<List<EntradaBlogDTO>> getAllEntradasBlog() {
        List<EntradaBlogDTO> entradaBlogDTOS = (entradaBlogService.getAllBlogs().stream().
                map(entradaBlogMapper::toDto).toList());
        return ResponseEntity.ok(entradaBlogDTOS);
    }
}
