package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Flair;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Moderator;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CommunityDTO {

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
}
