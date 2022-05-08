package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.PostDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.service.PostService;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

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
}
