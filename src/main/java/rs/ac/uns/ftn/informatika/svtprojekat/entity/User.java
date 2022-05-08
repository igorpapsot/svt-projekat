package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;


@Table(name = "user")
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_username", unique = true, nullable = false)
    private String username;

    @Column(name = "user_password", unique = true, nullable = false)
    private String password;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_avatar", unique = true, nullable = false)
    private String avatar;

    @Column(name = "user_registration_date", unique = true, nullable = false)
    private LocalDate registrationDate;

    @Column(name = "user_is_banned", unique = true, nullable = false)
    private boolean isBanned;

    public User() {
    }

}
