package com.example.Blog.repository;

import com.example.Blog.dto.BlogEntryDTO;
import com.example.Blog.entity.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository  implements IBlogRepository{
    private List<BlogEntry> blogEntries;

    public BlogRepository() {
        this.blogEntries = new ArrayList<>();
    }

    public int addNewEntry(BlogEntryDTO blogEntryDTO){
        BlogEntry blogEntry = new BlogEntry(blogEntryDTO.getId(), blogEntryDTO.getTitle(), blogEntryDTO.getAuthor(), blogEntryDTO.getDate());
        this.blogEntries.add(blogEntry);
        return blogEntry.getId();
    }

    @Override
    public BlogEntry getBlogEntry(int id) {
        return this.blogEntries.stream().filter(blogEntry -> blogEntry.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<BlogEntry> getAll() {
        return this.blogEntries;
    }
}
