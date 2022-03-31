package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "community_id", unique = true, nullable = false)
    private Integer id;

    private String name;

    private String description;

    private String creationDate;

    private List<String> rules;

    private boolean isSuspended;

    private String suspendedReason;


}
