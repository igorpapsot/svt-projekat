package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "administrator")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "administrator_id", unique = true, nullable = false)
    private Integer id;

    public Admin() {
    }

}
