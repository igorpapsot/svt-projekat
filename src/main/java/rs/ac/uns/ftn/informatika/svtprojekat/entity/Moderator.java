package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "moderator")
@Data
public class Moderator{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "moderator_id", unique = true, nullable = false)
    private Integer id;

    public Moderator() {
    }

}
