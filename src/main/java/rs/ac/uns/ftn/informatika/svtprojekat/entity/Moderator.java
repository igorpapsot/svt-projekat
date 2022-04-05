package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "moderator")
public class Moderator{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "moderator_id", unique = true, nullable = false)
    private Integer id;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Community> communities = new HashSet<Community>();

    public Moderator() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moderator)) return false;
        Moderator moderator = (Moderator) o;
        return Objects.equals(getId(), moderator.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Moderator{" +
                "id=" + id +
                '}';
    }
}
