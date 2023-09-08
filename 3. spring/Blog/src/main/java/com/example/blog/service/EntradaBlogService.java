package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.dto.IdDTO;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.EntradaBlogRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    @Autowired
    EntradaBlogRepositoryImp entradaBlogRepositoryImp;

    @Autowired
    ObjectMapper mapper;

    @Override
     public IdDTO save(EntradaBlogDto entradaBlogDto){
        EntradaBlog entradaBlog = mapper.convertValue(entradaBlogDto, EntradaBlog.class);
        Integer id = entradaBlogRepositoryImp.save(entradaBlog);
        return new IdDTO(id);
    }

    @Override
    public EntradaBlogDto get(Integer id){
        EntradaBlog entradaBlog = entradaBlogRepositoryImp.get(id);
        if(entradaBlog == null){
            throw new NotFoundException("No se encontró la entrada con el id: " + id);
        }

        return  mapper.convertValue(entradaBlog, EntradaBlogDto.class);
    };

    @Override
    public List<EntradaBlogDto> getAll(){

        List<EntradaBlogDto> list = new ArrayList<>();
        for(EntradaBlog entrada : entradaBlogRepositoryImp.getAll()){
            list.add(mapper.convertValue(entrada, EntradaBlogDto.class));
        }

        return list;
    };
}
