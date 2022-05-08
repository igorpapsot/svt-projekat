package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "report")
@Data
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "report_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "reason", nullable = false)
    private ReportReasonENUM reason;

    @Column(name = "timestamp", nullable = false)
    private LocalDate timestamp;

    @Column(name = "accepted", nullable = false)
    private boolean accepted;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User byUser;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    public Report() {
    }

}
