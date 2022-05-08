package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Flair;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PostDTO implements Serializable {

    private Integer id;

    private String title;

    private String text;

    private LocalDate creationDate;

    private String imagePath;

    private User user;

    private Flair flair;

    public PostDTO() {
    }

    public PostDTO(Integer id, String title, String text, LocalDate creationDate, String imagePath, User user, Flair flair) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.imagePath = imagePath;
        this.user = user;
        this.flair = flair;
    }

    public PostDTO(Post post) {
        this(post.getId(), post.getTitle(), post.getText(), post.getCreationDate(), post.getImagePath(), post.getUser(), post.getFlair());
                //(category.getParent() != null && category.getParent().getId() != null) ? new CategoryDTO(category.getParent()) : new CategoryDTO());
    }
}
