package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.PostDto;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
}
