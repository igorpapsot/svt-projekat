package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import rs.ac.uns.ftn.informatika.jpa.model.Exam;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
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

    @Column(name = "user_registrationDate", unique = true, nullable = false)
    private LocalDate registrationDate;

    @Column(name = "user_isBanned", unique = true, nullable = false)
    private boolean isBanned;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<Comment>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reaction> reactions = new HashSet<Reaction>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Banned> bannedList = new HashSet<Banned>();

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(Set<Reaction> reactions) {
        this.reactions = reactions;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Banned> getBannedList() {
        return bannedList;
    }

    public void setBannedList(Set<Banned> bannedList) {
        this.bannedList = bannedList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isBanned() == user.isBanned() && Objects.equals(getId(), user.getId()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getAvatar(), user.getAvatar()) && Objects.equals(getRegistrationDate(), user.getRegistrationDate()) && Objects.equals(getComments(), user.getComments()) && Objects.equals(getReactions(), user.getReactions()) && Objects.equals(getPosts(), user.getPosts()) && Objects.equals(getBannedList(), user.getBannedList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getEmail(), getAvatar(), getRegistrationDate(), isBanned(), getComments(), getReactions(), getPosts(), getBannedList());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", registrationDate=" + registrationDate +
                ", isBanned=" + isBanned +
                ", comments=" + comments +
                ", reactions=" + reactions +
                ", posts=" + posts +
                ", bannedList=" + bannedList +
                '}';
    }
}
