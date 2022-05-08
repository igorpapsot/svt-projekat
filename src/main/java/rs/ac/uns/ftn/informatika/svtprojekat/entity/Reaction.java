package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "reaction")
@Data
public class Reaction implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "reaction_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "reaction_reaction_type", unique = true, nullable = false)
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

}
