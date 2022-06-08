package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.RoleENUM;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private String avatar;

    private boolean isBanned;

    private RoleENUM role;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String avatar, boolean isBanned, RoleENUM role) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.isBanned = isBanned;
        this.role = role;
    }

    public UserDTO(User user) {
        this(user.getId(), user.getUsername(), user.getAvatar(), user.isBanned(), user.getRole());
    }
}
