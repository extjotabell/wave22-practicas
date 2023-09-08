package com.example.blogs.service;

import com.example.blogs.entity.EntradaBlog;
import com.example.blogs.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blogs.dto.BlogDTO;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    IBlogRepository iBlogRepository;

    private BlogService(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }

    @Override
    public String crearEntrada(BlogDTO blogDTO) {
        // Mappeo un BlogDTO a una EntradaBlog y se la mando al repositorio
        EntradaBlog entrada = new EntradaBlog(blogDTO.getId(),blogDTO.getNombre(), blogDTO.getTitulo(), blogDTO.getFechaPublicacion());
        return iBlogRepository.createEntrada(entrada);
    }

    @Override
    public BlogDTO getBlogDTOByID(int id) {
        EntradaBlog entradaBlog = iBlogRepository.getEntradaBlogById(id);
        return new BlogDTO(entradaBlog.getId(), entradaBlog.getNombre(), entradaBlog.getTitulo(), entradaBlog.getFechaPublicacion());
    }

    @Override
    public List<BlogDTO> getAllEntradasBlog() {
        return iBlogRepository.getAllEntradasBlog()
                .stream()
                .map(e -> new BlogDTO(e.getId(), e.getNombre(), e.getTitulo(), e.getFechaPublicacion()))
                .toList();
    }
}
