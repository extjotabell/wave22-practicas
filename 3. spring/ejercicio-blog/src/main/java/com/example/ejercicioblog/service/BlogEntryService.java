package com.example.ejercicioblog.service;

import com.example.ejercicioblog.dto.BlogEntryDTO;
import com.example.ejercicioblog.exception.BlogEntryIdAlreadyExistsException;
import com.example.ejercicioblog.exception.BlogEntryNotFoundException;
import com.example.ejercicioblog.model.BlogEntry;
import com.example.ejercicioblog.repository.IBlogEntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogEntryService implements IBlogEntryService {

    @Autowired
    private IBlogEntryRepository blogEntryRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public void addNewBlogEntry(BlogEntryDTO blogEntryDTO) throws BlogEntryIdAlreadyExistsException {
        if(blogEntryRepository.getBlogEntryById(blogEntryDTO.getId()) != null)
            throw new BlogEntryIdAlreadyExistsException("There is already an entry blog with id "+ blogEntryDTO.getId());
        BlogEntry blogEntry = mapper.map(blogEntryDTO, BlogEntry.class);
        blogEntryRepository.addNewBlogEntry(blogEntry);
    }

    @Override
    public List<BlogEntryDTO> getAllBlogEntries() {
        return blogEntryRepository.getAllBlogEntries().stream().map(b -> mapper.map(b, BlogEntryDTO.class)).toList();
    }

    @Override
    public BlogEntryDTO getBlogEntryById(int id) {
        BlogEntry blogEntry = blogEntryRepository.getBlogEntryById(id);
        if(blogEntry == null)
            throw new BlogEntryNotFoundException("Not found blog entry with id "+id);
        BlogEntryDTO blogEntryDTO = mapper.map(blogEntry, BlogEntryDTO.class);
        return blogEntryDTO;
    }
}
