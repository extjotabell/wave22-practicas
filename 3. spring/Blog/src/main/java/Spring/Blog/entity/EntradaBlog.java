package Spring.Blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
