package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private LocalDate registrationDate;

    private boolean isBanned;

    private String newPassword;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String password, String email, String avatar, LocalDate registrationDate, boolean isBanned) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.registrationDate = registrationDate;
        this.isBanned = isBanned;
        this.newPassword = newPassword;
    }

    public UserDTO(User user) {
        this(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getAvatar(), user.getRegistrationDate(), user.isBanned());
    }
}
