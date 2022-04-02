package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "banned")
public class Banned {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "banned_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "banned_timestamp", unique = true, nullable = false)
    private LocalDate timestamp;

    @Column(name = "banned_moderator", unique = true, nullable = false)
    private Moderator by;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id")
    private Community community;

    public Banned() {
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Moderator getBy() {
        return by;
    }

    public void setBy(Moderator by) {
        this.by = by;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banned)) return false;
        Banned banned = (Banned) o;
        return Objects.equals(getId(), banned.getId()) && Objects.equals(getTimestamp(), banned.getTimestamp()) && Objects.equals(getBy(), banned.getBy()) && Objects.equals(getUser(), banned.getUser()) && Objects.equals(getCommunity(), banned.getCommunity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTimestamp(), getBy(), getUser(), getCommunity());
    }

    @Override
    public String toString() {
        return "Banned{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", by=" + by +
                ", user=" + user +
                ", community=" + community +
                '}';
    }
}
