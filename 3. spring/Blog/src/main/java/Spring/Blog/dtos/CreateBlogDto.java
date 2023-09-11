package Spring.Blog.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBlogDto {
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
