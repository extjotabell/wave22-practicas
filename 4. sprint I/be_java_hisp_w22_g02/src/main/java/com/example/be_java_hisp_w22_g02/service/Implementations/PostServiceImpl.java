package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.repository.Implementations.UserRepositoryImpl;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.management.LockInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class PostServiceImpl implements IPostService {

    private final IUserRepository userRepository;
    public TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order) {
        List<FollowedPostDTO> followedPostDTOS;

        if(order != null){
            followedPostDTOS = userRepository.getFollowedPostLasTwoWeeksOrd(userId, order);
        }else{
            followedPostDTOS = userRepository.getFollowedPostLasTwoWeeks(userId);
        }

        TwoWeeksPostDTO twoWeeksPostDTO = new TwoWeeksPostDTO(userId,followedPostDTOS);

        return twoWeeksPostDTO;
    }


}
