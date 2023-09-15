package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;

    public UserServiceImpl(@Qualifier("IUserRepository") IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<TwoWeeksPostDTO> getLastTwoWeeksPostByUser(Long userID) {
        List<FollowedPostDTO> followedPostDTOS = new ArrayList<>();

        //List<Post> posts = userRepository.getFollowedPostLasTwoWeeks(userID);
        Map<Integer,Post> posts= userRepository.getFollowedPostLasTwoWeeks(userID);

        for (Map.Entry<Integer,Post> entry: posts.entrySet()) {
            followedPostDTOS.add(new FollowedPostDTO(entry.getKey().intValue(),entry.getValue()));
        }

        //List<FollowedPostDTO> followedPosts = userRepository.getFollowedPostLasTwoWeeks(userID);


        TwoWeeksPostDTO twoWeeksPostDTO = new TwoWeeksPostDTO(userID,posts);
    }
}
