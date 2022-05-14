package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Community;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.CommunityDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.service.CommunityService;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

import java.time.LocalDate;
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

    @PostMapping
    public ResponseEntity<CommunityDTO> postCommunity(@RequestBody CommunityDTO communityDTO){
        Community community = new Community();
        LocalDate date = LocalDate.now();

        community.setDescription(communityDTO.getDescription());
        community.setName(communityDTO.getName());
        community.setCreationDate(date.toString());
        community.setSuspended(false);
        community.setRules(communityDTO.getRules());
        community.setPosts(communityDTO.getPosts());
        community.setModerators(communityDTO.getModerators());
        community.setFlairs(communityDTO.getFlairs());

        communityService.save(community);
        return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommunityDTO> putCommunity(@RequestBody CommunityDTO communityDTO){
        if (communityDTO.getId() != null) {
            Community community = communityService.findOne(communityDTO.getId());

            community.setDescription(communityDTO.getDescription());
            community.setName(communityDTO.getName());
//            community.setFlairs(communityDTO.getFlairs());
//            community.setPosts(communityDTO.getPosts());
//            community.setModerators(communityDTO.getModerators());
//            community.setSuspended(communityDTO.isSuspended());
//            community.setRules(communityDTO.getRules());

            communityService.save(community);
            return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping
    public ResponseEntity deleteCommunity(@RequestBody CommunityDTO communityDTO) {
        if (communityDTO.getId() != null) {
            Community community = communityService.findOne(communityDTO.getId());

            communityService.remove(community.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }
}
