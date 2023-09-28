package com.meli.be_java_hisp_w22_g01.unitTest;

import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.PostRepositoryImp;
import com.meli.be_java_hisp_w22_g01.service.PostServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryImpTest {

    @InjectMocks
    PostRepositoryImp postRepository;

    /**
     * Testeo de buscar un post nulo
     */
    @Test
    @DisplayName("Testeo de post nulo")
    void postNull(){
        Post postNull = postRepository.getPostById(0);

        Assertions.assertNull(postNull);
    }

}
