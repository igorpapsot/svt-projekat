package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
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
