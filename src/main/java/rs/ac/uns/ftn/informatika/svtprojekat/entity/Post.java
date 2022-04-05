package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "post")
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

    //  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //  private Set<Comment> comments = new HashSet<Comment>();

    //    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //    private Set<Reaction> reactions = new HashSet<Reaction>();
    //
    //    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //    private Set<Report> reports = new HashSet<Report>();

    //    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //    @JoinColumn(name = "community_id")
    //    private Community community;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "flair_id")
    private Flair flair;


//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flair getFlair() {
        return flair;
    }

    public void setFlair(Flair flair) {
        this.flair = flair;
    }

}
