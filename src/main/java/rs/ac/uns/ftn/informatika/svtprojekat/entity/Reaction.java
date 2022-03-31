package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "reaction")
public class Reaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "reaction_id", unique = true, nullable = false)
    private Integer id;

    private ReactionType type;

    private LocalDate timestamp;
}
