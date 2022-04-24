package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Flair;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.time.LocalDate;

@Data
public class PostDTO {

    private Integer id;

    private String title;

    private String text;

    private LocalDate creationDate;

    private String imagePath;

    private User user;

    private Flair flair;

    public PostDTO() {
    }
}
