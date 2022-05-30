package rs.ac.uns.ftn.informatika.svtprojekat.service;

import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Reaction;

import java.util.List;

public interface ReactionService {

    List<Reaction> findAllByParent(Reaction parent);

    Reaction findOne(Integer id);

    List<Reaction> findAll();

    Reaction save(Reaction reaction);

    void remove(Integer id);

    boolean checkIfReactionExists(Integer userId, Post post);

    void undoReaction(Integer userId, Post post);

}
