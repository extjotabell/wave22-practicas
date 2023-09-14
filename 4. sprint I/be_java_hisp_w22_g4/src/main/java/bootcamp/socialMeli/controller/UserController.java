package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.repository.IUserRepository;
import bootcamp.socialMeli.repository.UserRepositoryImpl;
import bootcamp.socialMeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
