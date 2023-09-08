package Spring.Blog.service;

import Spring.Blog.dtos.BlogDto;
import Spring.Blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    BlogDto addBlog(BlogDto blogDto);
    BlogDto getById(int id);
    List<BlogDto> getAll();
}
