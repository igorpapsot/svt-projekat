package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;


@Table(name = "user")
@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @NotNull(message = "Username cannot be null")
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min = 5, max = 60, message = "Password must be between 6 and 25 characters")
    private String password;

    @Column(name = "email", nullable = false)
    @Email(message = "Email is not valid")
    private String email;

    @Column(name = "avatar", nullable = false)
    @NotNull(message = "Avatar cannot be null")
    private String avatar;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "is_banned", nullable = false)
    private boolean isBanned;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleENUM role;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "user")
    private Set<Moderator> moderators = new HashSet<Moderator>();

    public User() {
    }

}
