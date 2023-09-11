package Spring.Blog.service;

import Spring.Blog.dtos.BlogDto;
import Spring.Blog.dtos.CreateBlogDto;
import Spring.Blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    BlogDto addBlog(CreateBlogDto blogDto);
    BlogDto getById(int id);
    List<BlogDto> getAll();
}
