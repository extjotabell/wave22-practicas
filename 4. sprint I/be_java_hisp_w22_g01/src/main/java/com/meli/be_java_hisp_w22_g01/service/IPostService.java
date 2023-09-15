package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;

import java.util.List;

public interface IPostService {
    void createPost (PostDto postDto);

    List<PostDto> orderByDate(String order);
}
