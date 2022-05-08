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

    @Column(name = "community_name", nullable = false)
    private String name;

    @Column(name = "community_description", nullable = false)
    private String description;

    @Column(name = "community_creation_date", nullable = false)
    private String creationDate;

    @ElementCollection
    @CollectionTable(name = "community_rules", joinColumns = @JoinColumn(name = "community_id")) // 2
    @Column(name = "rule")
    private List<String> rules;

    @Column(name = "community_is_suspended", nullable = false)
    private boolean isSuspended;

    @Column(name = "community_suspended_reason")
    private String suspendedReason;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<Post>();

    @ManyToMany(mappedBy = "communities", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Flair> flairs = new HashSet<Flair>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Moderator> moderators = new HashSet<Moderator>();

    public Community() {
    }

}
