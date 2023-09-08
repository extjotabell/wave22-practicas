package com.example.ejercicioblog.service;

import com.example.ejercicioblog.dto.BlogEntryDTO;
import com.example.ejercicioblog.exception.BlogEntryIdAlreadyExistsException;
import com.example.ejercicioblog.model.BlogEntry;

import java.util.List;

public interface IBlogEntryService {

    void addNewBlogEntry(BlogEntryDTO blogEntryDTO) throws BlogEntryIdAlreadyExistsException;
    List<BlogEntryDTO> getAllBlogEntries();
    BlogEntryDTO getBlogEntryById(int id);

}
