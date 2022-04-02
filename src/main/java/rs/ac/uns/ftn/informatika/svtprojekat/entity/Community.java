package rs.ac.uns.ftn.informatika.svtprojekat.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "community_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "community_name", unique = true, nullable = false)
    private String name;

    @Column(name = "community_description", unique = true, nullable = false)
    private String description;

    @Column(name = "community_creationDate", unique = true, nullable = false)
    private String creationDate;

    @Column(name = "community_rules", unique = true, nullable = false)
    private List<String> rules;

    @Column(name = "community_isSuspended", unique = true, nullable = false)
    private boolean isSuspended;

    @Column(name = "community_suspendedReason", unique = true, nullable = false)
    private String suspendedReason;

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Banned> banned = new HashSet<Banned>();

    @ManyToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Flair> flairs = new HashSet<Flair>();

    @ManyToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Moderator> moderators = new HashSet<Moderator>();

    public Community() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public String getSuspendedReason() {
        return suspendedReason;
    }

    public void setSuspendedReason(String suspendedReason) {
        this.suspendedReason = suspendedReason;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Banned> getBanned() {
        return banned;
    }

    public void setBanned(Set<Banned> banned) {
        this.banned = banned;
    }

    public Set<Flair> getFlairs() {
        return flairs;
    }

    public void setFlairs(Set<Flair> flairs) {
        this.flairs = flairs;
    }

    public Set<Moderator> getModerators() {
        return moderators;
    }

    public void setModerators(Set<Moderator> moderators) {
        this.moderators = moderators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Community)) return false;
        Community community = (Community) o;
        return isSuspended() == community.isSuspended() && Objects.equals(getId(), community.getId()) && Objects.equals(getName(), community.getName()) && Objects.equals(getDescription(), community.getDescription()) && Objects.equals(getCreationDate(), community.getCreationDate()) && Objects.equals(getRules(), community.getRules()) && Objects.equals(getSuspendedReason(), community.getSuspendedReason()) && Objects.equals(getPosts(), community.getPosts()) && Objects.equals(getBanned(), community.getBanned()) && Objects.equals(getFlairs(), community.getFlairs()) && Objects.equals(getModerators(), community.getModerators());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getCreationDate(), getRules(), isSuspended(), getSuspendedReason(), getPosts(), getBanned(), getFlairs(), getModerators());
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", rules=" + rules +
                ", isSuspended=" + isSuspended +
                ", suspendedReason='" + suspendedReason + '\'' +
                ", posts=" + posts +
                ", banned=" + banned +
                ", flairs=" + flairs +
                ", moderators=" + moderators +
                '}';
    }
}
