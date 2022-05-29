package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.PostDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.service.CommunityService;
import rs.ac.uns.ftn.informatika.svtprojekat.service.FlairService;
import rs.ac.uns.ftn.informatika.svtprojekat.service.PostService;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private FlairService flairService;

    @Autowired
    private CommunityService communityService;

    //@PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts() {
        List<Post> posts = postService.findAll();

        List<PostDTO> postsDTO = new ArrayList<>();
        for (Post p : posts) {
            System.out.println(p.toString());
            postsDTO.add(new PostDTO(p));
        }

        return new ResponseEntity<>(postsDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable("id") Integer id) {
        Post post = postService.findOne(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PostDTO(post), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> postPost(@RequestBody PostDTO postDTO){
        Post post = new Post();
        LocalDate date = LocalDate.now();

        post.setFlair(flairService.findOne(postDTO.getFlair().getId()));
        post.setCommunity(communityService.findOne(postDTO.getCommunity().getId()));
        post.setUser(userService.findOne(postDTO.getUser().getId()));

        post.setCreationDate(date);
        post.setImagePath(postDTO.getImagePath());
        post.setText(postDTO.getText());
        post.setTitle(postDTO.getTitle());

        if(post.getImagePath() == null || post.getText() == null ||
            post.getTitle() == null || post.getFlair() == null ||
            post.getCommunity() == null || post.getUser() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        postService.save(post);
        return new ResponseEntity<>(new PostDTO(post), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> putPost(@RequestBody PostDTO postDTO, @PathVariable("id") Integer id){
        if (id != null) {
            Post post = postService.findOne(id);

            if(post == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            post.setFlair(flairService.findOne(postDTO.getFlair().getId()));
            post.setCommunity(communityService.findOne(postDTO.getCommunity().getId()));
            post.setUser(userService.findOne(postDTO.getUser().getId()));

            post.setImagePath(postDTO.getImagePath());
            post.setText(postDTO.getText());
            post.setTitle(postDTO.getTitle());

            if(post.getImagePath() == null || post.getText() == null ||
                    post.getTitle() == null || post.getFlair() == null ||
                    post.getCommunity() == null || post.getUser() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            postService.save(post);
            return new ResponseEntity<>(new PostDTO(post), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePost(@PathVariable("id") Integer id) {
        if (id != null) {
            Post post = postService.findOne(id);

            if(post == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            postService.remove(post.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
