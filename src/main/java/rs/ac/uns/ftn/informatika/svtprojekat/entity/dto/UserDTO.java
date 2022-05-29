package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private String avatar;

    private boolean isBanned;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String avatar, boolean isBanned) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.isBanned = isBanned;
    }

    public UserDTO(User user) {
        this(user.getId(), user.getUsername(), user.getAvatar(), user.isBanned());
    }
}
