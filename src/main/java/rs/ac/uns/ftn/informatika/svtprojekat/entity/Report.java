package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "report_id", unique = true, nullable = false)
    private Integer id;

    private ReportReasonENUM reason;

    private LocalDate timestamp;

    private User byUser;

    private boolean accepted;
}
