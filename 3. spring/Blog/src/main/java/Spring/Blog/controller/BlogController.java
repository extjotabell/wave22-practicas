package Spring.Blog.controller;

import Spring.Blog.dtos.BlogDto;
import Spring.Blog.service.IBlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    private IBlogService _blogService;

    public BlogController(IBlogService _blogService) {
        this._blogService = _blogService;
    }

    @GetMapping("/blog/{id}")
    public BlogDto getById(@PathVariable int id)
    {
        return _blogService.getById(id);
    }

    @GetMapping("/blogs")
    public List<BlogDto> getAll()
    {
        return _blogService.getAll();
    }
}
