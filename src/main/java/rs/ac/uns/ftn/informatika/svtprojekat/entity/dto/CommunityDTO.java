package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.*;

import java.io.Serializable;
import java.util.Set;

@Data
public class CommunityDTO implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private String creationDate;

    private boolean isSuspended;

    private String suspendedReason;

    public CommunityDTO() {
    }

    public CommunityDTO(Integer id, String name, String description, String creationDate, boolean isSuspended, String suspendedReason) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.isSuspended = isSuspended;
        this.suspendedReason = suspendedReason;
    }

    public CommunityDTO(Community community) {
        this(community.getId(), community.getName(), community.getDescription(), community.getCreationDate(), community.isSuspended(), community.getSuspendedReason());
    }
}
