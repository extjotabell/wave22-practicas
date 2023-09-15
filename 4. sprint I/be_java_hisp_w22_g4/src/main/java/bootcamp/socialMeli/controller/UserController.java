package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.FollowersCountDto;
import bootcamp.socialMeli.dto.FollowersListDto;
import bootcamp.socialMeli.dto.NameOrderEnumDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.service.IUserService;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getUsers()
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    // US 01
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId,
                                        @PathVariable Integer userIdToFollow)
    {
        this.userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // US 02
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDto> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    // US 03
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDto> getFollowersList(@PathVariable int userId, @RequestParam @Nullable NameOrderEnumDto nameOrder) {
        return new ResponseEntity<>(userService.getFollowersList(userId, nameOrder), HttpStatus.OK);
    }
}
