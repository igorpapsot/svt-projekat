package rs.ac.uns.ftn.informatika.svtprojekat.service;

import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAllByParent(Post parent);

    Post findOne(Integer id);

    List<Post> findAll();

    Post save(Post post);

    void remove(Integer id);

}
