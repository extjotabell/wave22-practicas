package com.example.ejercicioblog.repository;

import com.example.ejercicioblog.model.BlogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogEntryRepository implements IBlogEntryRepository {

    List<BlogEntry> database = new ArrayList<>();

    @Override
    public void addNewBlogEntry(BlogEntry blogEntry) {
        database.add(blogEntry);
    }

    @Override
    public List<BlogEntry> getAllBlogEntries() {
        return database;
    }

    @Override
    public BlogEntry getBlogEntryById(int id) {
        BlogEntry blogEntry= database.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        return blogEntry;

    }
}
