package Spring.Blog.repository;

import Spring.Blog.dtos.BlogDto;
import Spring.Blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    EntradaBlog addBlog(BlogDto blogDto);
    EntradaBlog getById(int id);
    List<EntradaBlog> getAll();
}
