package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "reaction")
public class Reaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "reaction_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "reaction_reactionType", unique = true, nullable = false)
    private ReactionType type;

    @Column(name = "reaction_timestamp", unique = true, nullable = false)
    private LocalDate timestamp;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    public Reaction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReactionType getType() {
        return type;
    }

    public void setType(ReactionType type) {
        this.type = type;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reaction)) return false;
        Reaction reaction = (Reaction) o;
        return Objects.equals(getId(), reaction.getId()) && getType() == reaction.getType() && Objects.equals(getTimestamp(), reaction.getTimestamp()) && Objects.equals(getUser(), reaction.getUser()) && Objects.equals(getComment(), reaction.getComment()) && Objects.equals(getPost(), reaction.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getTimestamp(), getUser(), getComment(), getPost());
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "id=" + id +
                ", type=" + type +
                ", timestamp=" + timestamp +
                ", user=" + user +
                ", comment=" + comment +
                ", post=" + post +
                '}';
    }
}
