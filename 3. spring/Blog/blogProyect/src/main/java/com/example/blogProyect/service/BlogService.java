package com.example.blogProyect.service;

import com.example.blogProyect.dtos.EntradaBlogDto;
import com.example.blogProyect.entity.EntradaBlog;
import com.example.blogProyect.exceptions.BlogExistsException;
import com.example.blogProyect.exceptions.NotFoundException;
import com.example.blogProyect.mapeo.MapDtos;
import com.example.blogProyect.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlogService implements IBlogService{

    private BlogRepository blogRepository;
    private MapDtos mapDtos;

    @Override
    public void add(EntradaBlogDto entradaBlog) {
        try{
            if(blogRepository.findById(entradaBlog.getIdBlog()) != null){
                throw new BlogExistsException(entradaBlog.getIdBlog());
            }
            EntradaBlog entrada = new EntradaBlog(
                    entradaBlog.getIdBlog(),
                    entradaBlog.getTitulo(),
                    entradaBlog.getAutor(),
                    entradaBlog.getFecha()
            );

            blogRepository.add(entrada);

        } catch(Exception e){
           throw e;
        }
    }

    @Override
    public List<EntradaBlogDto> findAll() {

       if(blogRepository.findAll().isEmpty()){
           throw new NotFoundException();
       } else {
           return  blogRepository.findAll().stream().map(mapDtos::toDto).collect(Collectors.toList());
       }
    }


}
