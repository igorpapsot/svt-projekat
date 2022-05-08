package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "community")
@Data
public class Community implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "community_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "creation_date", nullable = false)
    private String creationDate;

    @Column(name = "community_is_suspended", nullable = false)
    private boolean isSuspended;

    @Column(name = "suspended_reason")
    private String suspendedReason;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rule> rules = new HashSet<>();

    @ManyToMany(mappedBy = "communities", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Flair> flairs = new HashSet<Flair>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Moderator> moderators = new HashSet<Moderator>();

    public Community() {
    }

}
