package com.example.blogProyect.mapeo;

import com.example.blogProyect.dtos.EntradaBlogDto;
import com.example.blogProyect.entity.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;


@Data
@Component
public class MapDtos {

    public MapDtos(){

    }
    public EntradaBlogDto toDto(EntradaBlog entradaBlog){
        EntradaBlogDto nuevoDto = new EntradaBlogDto(
                entradaBlog.getIdBlog(),
                entradaBlog.getTitulo(),
                entradaBlog.getAutor(),
                entradaBlog.getFecha()
        );
        return nuevoDto;
    }


}
