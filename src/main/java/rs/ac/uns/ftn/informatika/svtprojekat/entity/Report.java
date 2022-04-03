package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "report_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "report_reason", unique = true, nullable = false)
    private ReportReasonENUM reason;

    @Column(name = "report_timestamp", unique = true, nullable = false)
    private LocalDate timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User byUser;

    @Column(name = "report_accepted", unique = true, nullable = false)
    private boolean accepted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Report() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReportReasonENUM getReason() {
        return reason;
    }

    public void setReason(ReportReasonENUM reason) {
        this.reason = reason;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public User getByUser() {
        return byUser;
    }

    public void setByUser(User byUser) {
        this.byUser = byUser;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
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
        if (!(o instanceof Report)) return false;
        Report report = (Report) o;
        return isAccepted() == report.isAccepted() && Objects.equals(getId(), report.getId()) && getReason() == report.getReason() && Objects.equals(getTimestamp(), report.getTimestamp()) && Objects.equals(getByUser(), report.getByUser()) && Objects.equals(getComment(), report.getComment()) && Objects.equals(getPost(), report.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReason(), getTimestamp(), getByUser(), isAccepted(), getComment(), getPost());
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reason=" + reason +
                ", timestamp=" + timestamp +
                ", byUser=" + byUser +
                ", accepted=" + accepted +
                ", comment=" + comment +
                ", post=" + post +
                '}';
    }
}
