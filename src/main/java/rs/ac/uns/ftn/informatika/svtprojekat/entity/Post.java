package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "post_title", unique = true, nullable = false)
    private String title;

    @Column(name = "post_text", unique = true, nullable = false)
    private String text;

    @Column(name = "post_creation_date", unique = true, nullable = false)
    private LocalDate creationDate;

    @Column(name = "post_image_path", unique = true, nullable = false)
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "flair_id")
    private Flair flair;

    public Post() {
    }

}
