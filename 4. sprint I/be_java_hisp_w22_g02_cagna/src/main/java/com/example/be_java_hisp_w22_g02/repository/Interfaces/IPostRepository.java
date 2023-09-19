package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Promotion;

public interface IPostRepository {
    Post save(Post post);
    Promotion savePromo(Promotion post);
}
