package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Comment;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.ReactionType;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.time.LocalDate;

@Data
public class ReactionDTO {

    private Integer id;

    private ReactionType type;

    private LocalDate timestamp;

    private User user;

    private Comment comment;

    private Post post;

    public ReactionDTO() {
    }
}
