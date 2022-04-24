package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private LocalDate registrationDate;

    private boolean isBanned;

    public UserDTO() {
    }
}
