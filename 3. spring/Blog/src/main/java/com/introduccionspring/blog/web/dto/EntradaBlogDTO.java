package com.introduccionspring.blog.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {
    private Long id;
    private String titulo;
    private String nombreAutor;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaPublicacion;
}
