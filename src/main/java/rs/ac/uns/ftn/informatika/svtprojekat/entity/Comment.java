package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "comment")
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

//    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Reaction> reactions = new HashSet<Reaction>();

//    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Report> reports = new HashSet<Report>();

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User belongsTo) {
        this.user = belongsTo;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return isDeleted() == comment.isDeleted() && Objects.equals(getId(), comment.getId()) && Objects.equals(getText(), comment.getText()) && Objects.equals(getTimestamp(), comment.getTimestamp()) && Objects.equals(getUser(), comment.getUser()) && Objects.equals(getPost(), comment.getPost()) && Objects.equals(getComments(), comment.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getTimestamp(), isDeleted(), getUser(), getPost(), getComments());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                ", isDeleted=" + isDeleted +
                ", user=" + user +
                ", post=" + post +
                ", comments=" + comments +
                '}';
    }
}
