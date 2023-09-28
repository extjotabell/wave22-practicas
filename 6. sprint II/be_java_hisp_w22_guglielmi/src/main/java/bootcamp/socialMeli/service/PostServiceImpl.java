package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IUserService userService;
    private final ObjectMapper mapper;

    public PostServiceImpl(IPostRepository postRepository,IUserService userService, ObjectMapper mapper)
    {
        this.postRepository = postRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order) {
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowed();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(idUser ->{
            List<Post> posts = postRepository.getLatestPostsByUserId(idUser);
            posts.forEach(post -> {postDtoList.add(mapper.convertValue(post, PostDto.class));
            });
        });

        if(order == ProductOrderListEnum.date_asc) return new FollowedPostListDto(
                userId, postDtoList.stream().sorted(Comparator.comparing(PostDto::getDate)).
                collect(Collectors.toList()));

        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.getDate().compareTo(date1.getDate())).
                collect(Collectors.toList()));
    }

    @Override
    public String addPost(PostDto postDto) {
        User user = userService.findUserById(postDto.getUserId());

        if(user.getRol() == RolEnum.COMPRADOR) user.setRol(RolEnum.VENDEDOR);
        Post post = postRepository.addPost(mapper.convertValue(postDto, Post.class));

        user.getPostList().add(post.getPostId());
        return "Se agrego exitosamente un nuevo post con el id #" + post.getPostId();
    }
}
