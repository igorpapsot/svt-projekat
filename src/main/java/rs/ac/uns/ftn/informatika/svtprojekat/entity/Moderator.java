package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "moderator")
@Data
public class Moderator extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "moderator_id", unique = true, nullable = false)
    private Integer id;

    public Moderator() {
    }

}
