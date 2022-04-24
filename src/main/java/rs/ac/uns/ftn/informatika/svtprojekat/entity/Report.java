package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "report")
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "report_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "report_reason", unique = true, nullable = false)
    private ReportReasonENUM reason;

    @Column(name = "report_timestamp", unique = true, nullable = false)
    private LocalDate timestamp;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User byUser;

    @Column(name = "report_accepted", unique = true, nullable = false)
    private boolean accepted;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    public Report() {
    }

}
