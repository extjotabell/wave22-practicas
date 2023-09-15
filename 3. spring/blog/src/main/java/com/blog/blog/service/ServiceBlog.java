package com.blog.blog.service;

import com.blog.blog.entity.EntradaBlog;
import com.blog.blog.entity.EntradaBlogDto;
import com.blog.blog.exception.IdAlreadyExistsException;
import com.blog.blog.exception.NotFoundException;
import com.blog.blog.repository.IRepositoryBlog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBlog implements IServiceBlog{

    private final IRepositoryBlog repository;

    public ServiceBlog(IRepositoryBlog repository) {
        this.repository = repository;
    }

    @Override
    public void newEntry(EntradaBlogDto entradaBlogDto) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<EntradaBlog> entradaBlog = repository.getAllEntries().stream()
                        .filter(e -> e.getId() == entradaBlogDto.getId())
                        .findFirst();

        if(entradaBlog.isPresent()){
            throw new IdAlreadyExistsException("Ya existe una entrada con el id " + entradaBlogDto.getId());
        }

        repository.newEntry(mapper.convertValue(entradaBlogDto, EntradaBlog.class));
    }

    @Override
    public EntradaBlogDto getEntry(int id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<EntradaBlogDto> entradaBlogDto = repository.getAllEntries().stream()
                .filter(e -> e.getId() == id)
                .map(e -> mapper.convertValue(e, EntradaBlogDto.class))
                .findFirst();

        if(!entradaBlogDto.isPresent()){
            throw new NotFoundException("No existe ninguna entrada con el id " + id);
        }

        return entradaBlogDto.get();
    }

    @Override
    public List<EntradaBlogDto> getAllEntries() {
        ObjectMapper mapper = new ObjectMapper();
        List<EntradaBlogDto> entradaBlogDtoList= repository.getAllEntries().stream()
                .map(e -> mapper.convertValue(e, EntradaBlogDto.class))
                .toList();

        if(entradaBlogDtoList.isEmpty()){
            throw new NotFoundException("No hay entradas en el blog");
        }

        return entradaBlogDtoList;
    }
}
