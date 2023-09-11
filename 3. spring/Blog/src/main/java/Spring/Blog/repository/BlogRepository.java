package Spring.Blog.repository;

import Spring.Blog.dtos.BlogDto;
import Spring.Blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{
    private List<EntradaBlog> blogs = new ArrayList<>();
    @Override
    public EntradaBlog addBlog(BlogDto blogDto) {
        EntradaBlog nuevoblog = new EntradaBlog(
                blogs.size() + 1,
                blogDto.getTitulo(),
                blogDto.getNombreAutor(),
                blogDto.getFechaPublicacion());
        this.blogs.add(nuevoblog);
        return nuevoblog;
    }

    @Override
    public EntradaBlog getById(int id) {
        return blogs.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return blogs;
    }
}
