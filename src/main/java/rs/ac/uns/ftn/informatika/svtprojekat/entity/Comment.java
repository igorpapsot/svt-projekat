package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "comment_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "comment_text", unique = true, nullable = false)
    private String text;

    @Column(name = "comment_timestamp", unique = true, nullable = false)
    private LocalDate timestamp;

    @Column(name = "comment_is_deleted", unique = true, nullable = false)
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "replies_to")
    private Set<Comment> comments = new HashSet<Comment>();

    public Comment() {
    }

}
