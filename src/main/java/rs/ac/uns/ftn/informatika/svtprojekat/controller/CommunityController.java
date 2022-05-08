package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Community;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.CommunityDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.service.CommunityService;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping
    public ResponseEntity<List<CommunityDTO>> getCommunities() {
        List<Community> communities = communityService.findAll();

        List<CommunityDTO> communitiesDTO = new ArrayList<>();
        for (Community c : communities) {
            communitiesDTO.add(new CommunityDTO(c));
        }

        return new ResponseEntity<>(communitiesDTO, HttpStatus.OK);
    }
}
