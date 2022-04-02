package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "flair")
public class Flair {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "flair_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "flair_name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "flair", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<Post>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Community> communities = new HashSet<Community>();

    public Flair() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Community> getCommunities() {
        return communities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flair)) return false;
        Flair flair = (Flair) o;
        return Objects.equals(getId(), flair.getId()) && Objects.equals(getName(), flair.getName()) && Objects.equals(getPosts(), flair.getPosts()) && Objects.equals(getCommunities(), flair.getCommunities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPosts(), getCommunities());
    }

    public void setCommunities(Set<Community> communities) {
        this.communities = communities;
    }

    @Override
    public String toString() {
        return "Flair{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                ", communities=" + communities +
                '}';
    }
}
