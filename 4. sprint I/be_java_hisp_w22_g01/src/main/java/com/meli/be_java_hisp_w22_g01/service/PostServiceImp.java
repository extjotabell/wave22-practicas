package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements IPostService{

    @Autowired
    IPostRepository postRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void createPost(PostDto postDto) {
        Post post = mapper.convertValue(postDto, Post.class);
        postRepository.addPost(post);

    }

    @Override
    public List<PostDto> orderByDate(String order) {
        List<PostDto> listaPostdeSeguidos = new ArrayList<>();

        if (order.equals("date_asc")){
            return listaPostdeSeguidos.stream().sorted(Comparator.comparing(PostDto::getDate))
                    .collect(Collectors.toList());
        }else if(order.equals("date_desc")){
            return listaPostdeSeguidos.stream().sorted(Comparator.comparing(PostDto::getDate).reversed())
                    .collect(Collectors.toList());
        }
        return null;
    }
}
