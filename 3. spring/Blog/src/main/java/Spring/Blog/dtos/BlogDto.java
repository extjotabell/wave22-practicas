package Spring.Blog.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDto {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    public BlogDto(String titulo, String nombreAutor, String fechaPublicacion) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
