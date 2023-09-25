package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository{

    HashMap<Integer, Post> postsDatabase;
    private final IUserRepository userRepository;


    public PostRepositoryImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.postsDatabase = this.loadPosts();
    }

    private HashMap<Integer, Post> loadPosts(){
        List<Post> posts = loadDataBase();
        HashMap<Integer, Post> postsHashmap = new HashMap<>();

        for (Post post : posts) {
            postsHashmap.put(post.getPostId(), post);
        }

        return postsHashmap;
    }

    private List<Post> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:post.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public List<Post> getAllPost() {
        return postsDatabase.values().stream().toList();
    }

    @Override
    public Post getPostById(int postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByFollowedUsers(int userId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        return this.postsDatabase.values().stream().filter(p -> p.getUserId() == userId).collect(Collectors.toList());
    }

    public List<Post> getLatestPostsByUserId(int userId)
    {
        return this.postsDatabase.values().stream().filter(p ->
                p.getUserId() == userId && p.getDate().isAfter(LocalDate.now().minusWeeks(2))).collect(Collectors.toList());
    }

    @Override
    public Post addPost(Post post) {
        List<Integer> postIdsList = new ArrayList<>(postsDatabase.keySet().stream().toList());
        Collections.sort(postIdsList);
        int idNewPost = postIdsList.get(postIdsList.size()-1)+1;
        post.setPostId(idNewPost);
        postsDatabase.put(idNewPost,post);

        return post;
    }
}
