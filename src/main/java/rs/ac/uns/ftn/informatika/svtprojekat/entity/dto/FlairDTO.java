package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Community;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class FlairDTO implements Serializable {

    private Integer id;

    private String name;

    private Set<Community> communities = new HashSet<Community>();

    public FlairDTO() {
    }

}
