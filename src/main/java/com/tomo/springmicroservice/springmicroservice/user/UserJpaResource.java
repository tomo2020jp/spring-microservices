package com.tomo.springmicroservice.springmicroservice.user;

import com.tomo.springmicroservice.springmicroservice.jpa.PostRepository;
import com.tomo.springmicroservice.springmicroservice.jpa.UserRepository;
import org.hibernate.EntityMode;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {
    private final UserRepository repository;
    private final PostRepository postRepository;

    public UserJpaResource(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        return user.get().getPosts();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
