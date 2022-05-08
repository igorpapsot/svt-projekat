package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "banned")
@Data
public class Banned implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "banned_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "banned_timestamp", unique = true, nullable = false)
    private LocalDate timestamp;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moderator_id")
    private Moderator moderator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id")
    private Community community;

    public Banned() {
    }

}
