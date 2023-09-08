package com.example.ejercicioblog.repository;

import com.example.ejercicioblog.model.BlogEntry;

import java.util.List;

public interface IBlogEntryRepository {

    void addNewBlogEntry(BlogEntry blogEntry);
    List<BlogEntry> getAllBlogEntries();
    BlogEntry getBlogEntryById(int id);

}
