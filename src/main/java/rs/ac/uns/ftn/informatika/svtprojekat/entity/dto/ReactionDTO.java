package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Comment;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.ReactionTypeENUM;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ReactionDTO implements Serializable {

    private Integer id;

    private ReactionTypeENUM type;

    private LocalDate timestamp;

    private UserDTO user;

    private CommentDTO comment;

    private PostDTO post;

    public ReactionDTO() {
    }
}
