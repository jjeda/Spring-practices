package me.jjeda.jpasampleapplication.post;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PostController {

    PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> list() {
       return postRepository.findAll();
    }

    @GetMapping("/post/{id}")
    public Optional<Post> getPost(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postPost(@RequestBody Post post) {
        post.setCreatedDateNow();
        postRepository.save(post);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
}
