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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moderator_id")
    private Moderator moderator;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banned)) return false;
        Banned banned = (Banned) o;
        return Objects.equals(getId(), banned.getId()) && Objects.equals(getTimestamp(), banned.getTimestamp()) && Objects.equals(getModerator(), banned.getModerator()) && Objects.equals(getUser(), banned.getUser()) && Objects.equals(getCommunity(), banned.getCommunity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTimestamp(), getModerator(), getUser(), getCommunity());
    }

    @Override
    public String toString() {
        return "Banned{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", by=" + moderator +
                ", user=" + user +
                ", community=" + community +
                '}';
    }
}
