package com.example.Blog.service;

import com.example.Blog.dto.BlogEntryDTO;
import com.example.Blog.entity.BlogEntry;
import com.example.Blog.repository.BlogRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public int createNewEntry(BlogEntryDTO blogEntryDTO) {
        return blogRepository.addNewEntry(blogEntryDTO);
    }

    @Override
    public BlogEntryDTO getBlogEntry(int id) {
        BlogEntry blogEntry = blogRepository.getBlogEntry(id);
        if(blogEntry != null)
            return new BlogEntryDTO(blogEntry.getId(),blogEntry.getTitle(), blogEntry.getAuthor(), blogEntry.getDate());
        return null;
    }

    @Override
    public List<BlogEntryDTO> getAllBlogEntries() {
        List<BlogEntry> blogEntries = blogRepository.getAll();
        List<BlogEntryDTO> blogEntriesDTO = new ArrayList<>();
        for (BlogEntry blogEntry :
                blogEntries) {
            blogEntriesDTO.add(new BlogEntryDTO(blogEntry.getId(), blogEntry.getTitle(), blogEntry.getAuthor(), blogEntry.getDate()));
        }
        return blogEntriesDTO;
    }
}
