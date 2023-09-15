package com.blog.blog.service;

import com.blog.blog.entity.EntradaBlogDto;

import java.util.List;

public interface IServiceBlog {
    void newEntry(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto getEntry(int id);

    List<EntradaBlogDto> getAllEntries();
}
