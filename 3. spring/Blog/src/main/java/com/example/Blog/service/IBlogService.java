package com.example.Blog.service;


import com.example.Blog.dto.BlogEntryDTO;
import com.example.Blog.entity.BlogEntry;

import java.util.List;

public interface IBlogService {
    int createNewEntry(BlogEntryDTO blogEntryDTO);
    BlogEntryDTO getBlogEntry(int id);
    List<BlogEntryDTO> getAllBlogEntries();
}
