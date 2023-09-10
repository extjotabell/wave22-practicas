package com.example.Blog.repository;

import com.example.Blog.dto.BlogEntryDTO;
import com.example.Blog.entity.BlogEntry;

import java.util.List;

public interface IBlogRepository {
    int addNewEntry(BlogEntryDTO blogEntryDTO);
    BlogEntry getBlogEntry(int id);
    List<BlogEntry> getAll();
}
