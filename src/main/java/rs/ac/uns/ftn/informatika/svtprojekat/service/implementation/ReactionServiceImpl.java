package rs.ac.uns.ftn.informatika.svtprojekat.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Reaction;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.repository.ReactionRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.service.ReactionService;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    ReactionRepository repository;

    @Autowired
    UserService userService;

    @Override
    public List<Reaction> findAllByParent(Reaction parent) {
        return null;
    }

    @Override
    public Reaction findOne(Integer id) {
        return null;
    }

    @Override
    public List<Reaction> findAll() {
        return null;
    }

    @Override
    public Reaction save(Reaction reaction) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public boolean checkIfReactionExists(Integer userId, Post post) {
        User user = userService.findOne(userId);
        if(repository.findByUserAndPost(user, post) == null) {
            return  false;
        }
        else  return  true;

    }

    @Override
    public void undoReaction(Integer userId, Post post) {
        User user = userService.findOne(userId);
        Reaction reaction = repository.findByUserAndPost(user, post);
        repository.deleteById(reaction.getId());
    }
}
