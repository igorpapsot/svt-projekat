package rs.ac.uns.ftn.informatika.svtprojekat.entity.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Comment;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Post;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.ReportReasonENUM;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ReportDTO implements Serializable {

    private Integer id;

    private ReportReasonENUM reason;

    private LocalDate timestamp;

    private User byUser;

    private boolean accepted;

    private Comment comment;

    private Post post;

    public ReportDTO() {
    }
}
