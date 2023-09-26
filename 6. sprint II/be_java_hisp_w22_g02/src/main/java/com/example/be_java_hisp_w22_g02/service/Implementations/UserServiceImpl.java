package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.*;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.be_java_hisp_w22_g02.enums.ResponseMessages.*;


@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;
    private ObjectMapper mapper;


    @Override
    public SuccessDTO followUser(int userId, int userIdToFollow) {
        if(!userRepository.existingUserById(userId))
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), userId));
        if(!userRepository.existingUserById(userIdToFollow))
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), userIdToFollow));
        if(userId == userIdToFollow)
            throw new BadRequestException(SAME_USER_ID.toString());
        if(userRepository.findById(userId).getFollowed().contains(userIdToFollow))
            throw new BadRequestException(FOLLOW_TWICE.toString());
        userRepository.followUser(userId, userIdToFollow);
        return new SuccessDTO(SUCCESSFUL_FOLLOW.toString());
    }

    @Override
    public UserFollowerDTO getFollowers(int id, String order) {
        if (!userRepository.existingUserById(id))
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), id));

        User user = userRepository.findById(id);
        UserFollowerDTO userFollowersDTO = new UserFollowerDTO(user.getUserId(), user.getUserName());
        userFollowersDTO.setFollowers(getUserFollowsInfo(user.getFollowers()));

        if(order != null){
            return sortingFollowers(userFollowersDTO, order);
        }
        return userFollowersDTO;
    }

    @Override
    public TotalFollowersDto getTotalFollowersByUserId(int userId) {
        if (!userRepository.existingUserById(userId)) {
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), userId));
        }

        User user = userRepository.findById(userId);

        return new TotalFollowersDto(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    @Override
    public SuccessDTO unfollowUser(int userId, int userIdToUnfollow) {
        if(!userRepository.existingUserById(userId))
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), userId));
        if(!userRepository.existingUserById(userIdToUnfollow))
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), userIdToUnfollow));
        if(userId == userIdToUnfollow)
            throw new BadRequestException(SAME_USER_ID.toString());
        userRepository.unFollowUser(userId, userIdToUnfollow);
        return new SuccessDTO(SUCCESSFUL_UNFOLLOW.toString());
    }

    @Override
    public UserFollowedDTO getFollowed(Integer id, String order) {
        if (!userRepository.existingUserById(id)) {
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), id));
        }

        User user = userRepository.findById(id);
        UserFollowedDTO userFollowedDTO = new UserFollowedDTO(user.getUserId(), user.getUserName());
        userFollowedDTO.setFollowed(getUserFollowsInfo(user.getFollowed()));

        if (order != null) {
            return sortingFollowed(userFollowedDTO, order);
        } else {
            return userFollowedDTO;
        }
    }

    @Override
    public PostDTO addUserPost(PostDTO postDTO){
        int userId = postDTO.getUserId();
        if(!userRepository.existingUserById(userId))
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), userId));
        Post post = mapper.convertValue(postDTO, Post.class);

        userRepository.addPostToUser(post, userId);
        return postDTO;
    }

    @Override
    public TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order) {
        List<Post> followedPost;

        if(!userRepository.existingUserById(userId)){
            throw new NotFoundException(String.format(USER_ID_NOT_FOUND.toString(), userId));
        }
        if(order != null){
            sortingByDateValidation(order);
            followedPost = userRepository.getFollowedPostLasTwoWeeksOrd(userId, order);
        }else{
            followedPost = userRepository.getFollowedPostLasTwoWeeks(userId);
        }
        List<PostDTO> followPostsDTOS = followedPost.stream().map(p -> mapper.convertValue(p, PostDTO.class)).collect(Collectors.toList());

        return new TwoWeeksPostDTO(userId,followPostsDTOS);
    }

    private UserFollowerDTO sortingFollowers(UserFollowerDTO user, String order){
        sortingByNameValidation(order);
        if(Objects.equals(order, NAME_ASC.toString())){
            user.setFollowers(user.getFollowers().stream().sorted(Comparator.comparing(UserFollowDTO::getUserName)).collect(Collectors.toList()));
        }
        else{
            user.setFollowers(user.getFollowers().stream().sorted(Comparator.comparing(UserFollowDTO::getUserName).reversed()).collect(Collectors.toList()));
        }
        return user;
    }

    private UserFollowedDTO sortingFollowed(UserFollowedDTO user, String order){
        sortingByNameValidation(order);
        if(Objects.equals(order, NAME_ASC.toString())){
            user.setFollowed(user.getFollowed().stream().sorted(Comparator.comparing(UserFollowDTO::getUserName)).collect(Collectors.toList()));
        }
        else{
            user.setFollowed(user.getFollowed().stream().sorted(Comparator.comparing(UserFollowDTO::getUserName).reversed()).collect(Collectors.toList()));
        }
        return user;
    }

    private void sortingByNameValidation(String order){
        if(!order.equals(NAME_ASC.toString()) && !order.equals(NAME_DESC.toString()))
            throw new BadRequestException(String.format(WRONG_SORTING_ORDER.toString(), order));
    }
    private void sortingByDateValidation(String order){
        if(!order.equals(DATE_ASC.toString()) && !order.equals(DATE_DESC.toString()))
            throw new BadRequestException(String.format(WRONG_SORTING_ORDER.toString(), order));
    }

    private List<UserFollowDTO> getUserFollowsInfo(List<Integer> listOfFollows){
        return listOfFollows.stream().map(i -> mapper.convertValue(userRepository.findById(i), UserFollowDTO.class)).collect(Collectors.toList());
    }

}
