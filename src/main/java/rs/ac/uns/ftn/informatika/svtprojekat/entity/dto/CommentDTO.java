package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Comment;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class CommentDTO {

    private Integer id;

    private String text;

    private LocalDate timestamp;

    private boolean isDeleted;

    private User user;

    private Post post;

    private Set<Comment> comments = new HashSet<Comment>();

    public CommentDTO() {
    }
}
