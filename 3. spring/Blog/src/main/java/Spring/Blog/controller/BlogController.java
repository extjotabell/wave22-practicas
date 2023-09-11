package Spring.Blog.controller;

import Spring.Blog.dtos.BlogDto;
import Spring.Blog.dtos.CreateBlogDto;
import Spring.Blog.service.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private IBlogService _blogService;

    public BlogController(IBlogService _blogService) {
        this._blogService = _blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogDto> addBlog(@RequestBody CreateBlogDto blog)
    {
        return ResponseEntity.ok(_blogService.addBlog(blog));
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getById(@PathVariable int id)
    {
        return ResponseEntity.ok( _blogService.getById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getAll()
    {
        return ResponseEntity.ok(_blogService.getAll());
    }
}
