package rs.ac.uns.ftn.informatika.svtprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
