package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Community;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.CommunityDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.PostDTO;
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

    @PostMapping
    public ResponseEntity<PostDTO> postCommunity(@RequestBody PostDTO postDTO){
        Post post = new Post();
        LocalDate date = LocalDate.now();

        post.setCreationDate(date);
        post.setFlair(postDTO.getFlair());
        post.setImagePath(postDTO.getImagePath());
        post.setText(postDTO.getText());
        post.setTitle(postDTO.getTitle());
        post.setUser(postDTO.getUser());

        postService.save(post);
        return new ResponseEntity<>(new PostDTO(post), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PostDTO> putCommunity(@RequestBody PostDTO postDTO){
        if (postDTO.getId() != null) {
            Post post = postService.findOne(postDTO.getId());

            post.setFlair(postDTO.getFlair());
            post.setImagePath(postDTO.getImagePath());
            post.setText(postDTO.getText());
            post.setTitle(postDTO.getTitle());
            post.setUser(postDTO.getUser());

            postService.save(post);
            return new ResponseEntity<>(new PostDTO(post), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping
    public ResponseEntity deleteCommunity(@RequestBody PostDTO postDTO) {
        if (postDTO.getId() != null) {
            Post post = postService.findOne(postDTO.getId());

            postService.remove(post.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }
}
