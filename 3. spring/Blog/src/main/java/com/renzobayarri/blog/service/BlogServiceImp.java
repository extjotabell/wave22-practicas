package com.renzobayarri.blog.service;

import com.renzobayarri.blog.dto.BlogDTO;
import com.renzobayarri.blog.entity.EntradaBlog;
import com.renzobayarri.blog.exceptions.BlogNotFoundException;
import com.renzobayarri.blog.exceptions.IdAlreadyExistsException;
import com.renzobayarri.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImp implements IBlogService {
    @Autowired
    BlogRepository repo;

    @Override
    public BlogDTO add(BlogDTO blog) {
        EntradaBlog newBlog = new EntradaBlog(blog.getId(), blog.getTitle(), blog.getAuthorName(), blog.getPublishDate());
        EntradaBlog blogSearch = repo.getById(newBlog.getId());
        if (blogSearch != null) {
            throw new IdAlreadyExistsException(newBlog.getId());
        }
        repo.add(newBlog);
        return blog;
    }

    @Override
    public BlogDTO getById(int id) {
        EntradaBlog searchBlog = repo.getById(id);
        if (searchBlog == null) {
            throw new BlogNotFoundException(id);
        }
        BlogDTO blog = new BlogDTO(searchBlog.getId(), searchBlog.getTitle(), searchBlog.getAuthorName(), searchBlog.getPublishDate());
        return blog;
    }

    @Override
    public List<BlogDTO> getall() {
        List<EntradaBlog> entradaBlogs = repo.getAll();
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (EntradaBlog blog : entradaBlogs) {
            blogDTOList.add(new BlogDTO(blog.getId(), blog.getTitle(), blog.getAuthorName(), blog.getPublishDate()));
        }
        return blogDTOList;
    }
}
