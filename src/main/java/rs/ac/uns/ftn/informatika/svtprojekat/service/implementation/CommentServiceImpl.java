package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Comment;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.CommentRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository repository;

    @Override
    public List<Comment> findAllByParent(Comment parent) {
        return null;
    }

    @Override
    public Comment findOne(Integer id) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
