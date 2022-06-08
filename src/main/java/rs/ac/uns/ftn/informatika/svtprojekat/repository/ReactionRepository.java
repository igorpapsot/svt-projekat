package rs.ac.uns.ftn.informatika.svtprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Reaction;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Integer> {

    Reaction findByUserAndPost(User user, Post post);

    List<Reaction> findAllByPost(Post post);

    void deleteAllByPost(Post post);
}
