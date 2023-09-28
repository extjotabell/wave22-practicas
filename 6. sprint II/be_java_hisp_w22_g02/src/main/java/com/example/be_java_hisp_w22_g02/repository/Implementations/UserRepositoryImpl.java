package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final Map<Integer, User> dbUser = new HashMap<>();

    public UserRepositoryImpl() {
        loadDataBase();
    }

    @Override
    public User findById(Integer id) {
        return dbUser.get(id);
    }


    @Override
    public void followUser(int userId, int userIdToFollow) {
        dbUser.get(userId).getFollowed().add(userIdToFollow);
        dbUser.get(userIdToFollow).getFollowers().add(userId);

    }


    private void loadDataBase(){
        File file;
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<User> users;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            users = objectMapper.readValue(file, new TypeReference<List<User>>(){});
            for (User user : users) {
                dbUser.put(user.getUserId(), user);
            }
            System.out.println("Database User loaded successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override

    public List<Post> getFollowedPostLasTwoWeeks(int id) {
        User user = dbUser.get(id);
        List<Integer> followed = user.getFollowed();

        List<Post> followedPost = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate lastTwoWeeks = today.minus(2, ChronoUnit.WEEKS);

                for (Integer u: followed) {
                    User userFollowed = findById(u);
                    for (Post p: userFollowed.getPosts()) {
                        if ((p.getDate().isAfter(lastTwoWeeks) || p.getDate().isEqual(lastTwoWeeks)) &&
                                (p.getDate().isBefore(today) || p.getDate().isEqual(today))) {

                            followedPost.add(p);
                        }
                    }
                }
                
        Comparator<Post> comparatorAsc = (f1, f2) -> f2.getDate()
                .compareTo(f1.getDate());

        Collections.sort(followedPost,comparatorAsc);

        return followedPost;
    }

    @Override
    public List<Post> getFollowedPostLasTwoWeeksOrd(int userId, String order) {
        List<Post> followedPost = getFollowedPostLasTwoWeeks(userId);
        Comparator<Post> comparatorAsc;
        if (order.equals("date_asc")) {
            comparatorAsc = (f1, f2) -> f1.getDate()
                    .compareTo(f2.getDate());
        } else {
            comparatorAsc = (f1, f2) -> f2.getDate()
                    .compareTo(f1.getDate());
        }
        Collections.sort(followedPost, comparatorAsc);
        return followedPost;

    }

    @Override
    public boolean existingUserById(Integer id) {
        return dbUser.containsKey(id);
    }

    @Override
    public void unFollowUser(Integer userId, Integer userIdToUnfollow) {
        dbUser.get(userId).getFollowed().remove(userIdToUnfollow);
        dbUser.get(userIdToUnfollow).getFollowers().remove(userId);
    }

    @Override
    public void addPostToUser(Post post, Integer id) {
        dbUser.get(id).getPosts().add(post);
    }

}