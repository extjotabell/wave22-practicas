package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {

    public List<Post> getFollowedPostLasTwoWeeks(Long id);

}
