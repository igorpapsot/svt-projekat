package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Community;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Flair;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Moderator;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CommunityDTO implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private String creationDate;

    private List<String> rules;

    private boolean isSuspended;

    private String suspendedReason;

    private Set<Post> posts = new HashSet<Post>();

    private Set<Flair> flairs = new HashSet<Flair>();

    private Set<Moderator> moderators = new HashSet<Moderator>();

    public CommunityDTO() {
    }

    public CommunityDTO(Integer id, String name, String description, String creationDate, List<String> rules, boolean isSuspended, String suspendedReason, Set<Post> posts, Set<Flair> flairs, Set<Moderator> moderators) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.rules = rules;
        this.isSuspended = isSuspended;
        this.suspendedReason = suspendedReason;
        this.posts = posts;
        this.flairs = flairs;
        this.moderators = moderators;
    }

    public CommunityDTO(Community community) {
        this(community.getId(), community.getName(), community.getDescription(), community.getCreationDate(), community.getRules(), community.isSuspended(), community.getSuspendedReason(), community.getPosts(), community.getFlairs(), community.getModerators());
    }
}
