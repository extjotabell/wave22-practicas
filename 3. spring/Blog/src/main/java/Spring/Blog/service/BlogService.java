package Spring.Blog.service;

import Spring.Blog.dtos.BlogDto;
import Spring.Blog.dtos.CreateBlogDto;
import Spring.Blog.entity.EntradaBlog;
import Spring.Blog.exception.NotFoundBlogException;
import Spring.Blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService{

    private IBlogRepository _blogRepository;

    public BlogService(IBlogRepository _blogRepository) {
        this._blogRepository = _blogRepository;
    }

    @Override
    public BlogDto addBlog(CreateBlogDto blogDto) {
        BlogDto newEntradaBlog = new BlogDto(blogDto.getTitulo(), blogDto.getNombreAutor(), blogDto.getFechaPublicacion());
        EntradaBlog blogCreado = _blogRepository.addBlog(newEntradaBlog);
        newEntradaBlog.setId(blogCreado.getId());
        return newEntradaBlog;
    }

    @Override
    public BlogDto getById(int id) {
        EntradaBlog blog = _blogRepository.getById(id);
        if (blog == null)
        {
            throw new NotFoundBlogException("Blog con el id "+ id + " no encontrado");
        }
        return new BlogDto(
                blog.getId(),
                blog.getTitulo(),
                blog.getNombreAutor(),
                blog.getFechaPublicacion());
    }

    @Override
    public List<BlogDto> getAll() {
        List<EntradaBlog> blog = _blogRepository.getAll();
        List<BlogDto> blogDtos = new ArrayList<>();
        blog.forEach(
                b ->
                {
                    blogDtos.add(new BlogDto(
                            b.getId(),
                            b.getTitulo(),
                            b.getNombreAutor(),
                            b.getFechaPublicacion()
                    ));
                }
        );
        return blogDtos;
    }
}
