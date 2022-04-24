package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.PostRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository repository;

    @Override
    public List<Post> findAllByParent(Post parent) {
        return null;
    }

    @Override
    public Post findOne(Integer id) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
