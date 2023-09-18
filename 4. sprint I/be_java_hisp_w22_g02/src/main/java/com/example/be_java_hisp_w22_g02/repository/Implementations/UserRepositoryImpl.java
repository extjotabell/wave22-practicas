package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
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
        User user = dbUser.get(userId);
        User userToFollow = dbUser.get(userId);
        user.addFollower(userToFollow);
    }


    @Override
    public List<User> getAllUsers() {
        List<User> newList = new ArrayList<>();
        dbUser.forEach((k,v) -> newList.add(v));
        return newList;
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

    public List<FollowedPostDTO> getFollowedPostLasTwoWeeks(int id) {
        User user = dbUser.get(id);
        List<User> followed = user.getFollowed();

        List<FollowedPostDTO> followedPostDTOS = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate lastTwoWeeks = today.minus(2, ChronoUnit.WEEKS);

        for (User u : followed) {
            for (Post p : u.getPosts()) {
                if ((p.getDate().isAfter(lastTwoWeeks) || p.getDate().isEqual(lastTwoWeeks)) &&
                        (p.getDate().isBefore(today) || p.getDate().isEqual(today))) {

                    followedPostDTOS.add(new FollowedPostDTO(u.getUserId(),p));
                }
            }
        }

        Comparator<FollowedPostDTO> comparatorAsc = (f1, f2) -> f2.getPost().getDate()
                .compareTo(f1.getPost().getDate());

        Collections.sort(followedPostDTOS,comparatorAsc);

        return followedPostDTOS;
    }

    @Override
    public List<FollowedPostDTO> getFollowedPostLasTwoWeeksOrd(int userId, String order) {
        List<FollowedPostDTO> followedPostDTOS = getFollowedPostLasTwoWeeks(userId);
        if (order.equals("date_asc")) {
            Comparator<FollowedPostDTO> comparatorAsc = (f1, f2) -> f1.getPost().getDate()
                    .compareTo(f2.getPost().getDate());
            Collections.sort(followedPostDTOS, comparatorAsc);
        } else {
            Comparator<FollowedPostDTO> comparatorAsc = (f1, f2) -> f2.getPost().getDate()
                    .compareTo(f1.getPost().getDate());
            Collections.sort(followedPostDTOS, comparatorAsc);
        }
        return followedPostDTOS;

    }
    public User getFollowers ( int id){
        return findById(id);

    }

}