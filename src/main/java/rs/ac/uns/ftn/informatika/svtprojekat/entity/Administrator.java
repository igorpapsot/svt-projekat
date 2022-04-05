package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "administrator")
public class Administrator{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "administrator_id", unique = true, nullable = false)
    private Integer id;

    public Administrator() {
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
        if (!(o instanceof Administrator)) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                '}';
    }
}
