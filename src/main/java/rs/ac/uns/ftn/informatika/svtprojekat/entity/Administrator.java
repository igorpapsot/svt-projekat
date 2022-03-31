package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "administrator")
public class Administrator extends User{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "administrator_id", unique = true, nullable = false)
    private Integer id;
}
