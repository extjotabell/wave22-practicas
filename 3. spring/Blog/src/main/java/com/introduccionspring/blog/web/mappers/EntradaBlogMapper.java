package com.introduccionspring.blog.web.mappers;

import com.introduccionspring.blog.entities.EntradaBlog;
import com.introduccionspring.blog.web.dto.EntradaBlogDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntradaBlogMapper {
    EntradaBlog toEntity(EntradaBlogDTO entradaBlogDTO);
    EntradaBlogDTO toDto(EntradaBlog entradaBlog);
}
