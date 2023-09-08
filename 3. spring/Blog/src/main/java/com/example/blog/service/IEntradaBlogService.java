package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.dto.IdDTO;

import java.util.List;

public interface IEntradaBlogService {

    IdDTO save(EntradaBlogDto entradaBlogDto);

    EntradaBlogDto get(Integer id);

    List<EntradaBlogDto> getAll();

}
