package com.w22_g03.be_java_hisp_w22_g03.controller;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.UserFollowedSellersPostsDTO;
import com.w22_g03.be_java_hisp_w22_g03.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@Validated
public class PostController {

    private PostService postService;

    //US 0005
    @PostMapping("/post")
    public ResponseEntity<PostDTO> addPost(@RequestBody @Valid PostDTO postDTO) {
        return ResponseEntity.ok(postService.addPost(postDTO));
    }

    //US 0006
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedSellersPostsDTO> getFollowedUsersPostsById(@PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Long userId,
                                                                                 @RequestParam(required = false) @Pattern(regexp = "^date_(asc|desc)$", message = "Orden no válido, Solamente acepta date_asc o date_desc") String order) {
        if (Objects.nonNull(order)) {
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId, order));
        } else {
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId));
        }
    }

}