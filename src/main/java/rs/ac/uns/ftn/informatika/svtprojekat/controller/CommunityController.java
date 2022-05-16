package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Community;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.CommunityDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.service.CommunityService;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommunityDTO> getCommunity(@PathVariable("id") Integer id) {
        Community community = communityService.findOne(id);
        if (community == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommunityDTO> postCommunity(@RequestBody CommunityDTO communityDTO){
        Community community = new Community();
        LocalDate date = LocalDate.now();

        community.setDescription(communityDTO.getDescription());
        community.setName(communityDTO.getName());
        community.setCreationDate(date.toString());
        community.setSuspended(false);
//        community.setSuspended(communityDTO.isSuspended());
//        community.setSuspendedReason(communityDTO.getSuspendedReason());

        if(community.getDescription() == null || community.getName() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        communityService.save(community);
        return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommunityDTO> putCommunity(@RequestBody CommunityDTO communityDTO){
        if (communityDTO.getId() != null) {
            Community community = communityService.findOne(communityDTO.getId());

            if(community == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            community.setDescription(communityDTO.getDescription());
            community.setName(communityDTO.getName());
            community.setSuspended(communityDTO.isSuspended());
            community.setSuspendedReason(communityDTO.getSuspendedReason());
//            community.setCreationDate(communityDTO.getCreationDate());

            if(community.getDescription() == null || community.getName() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            communityService.save(community);
            return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping
    public ResponseEntity deleteCommunity(@RequestBody CommunityDTO communityDTO) {
        if (communityDTO.getId() != null) {
            Community community = communityService.findOne(communityDTO.getId());

            if(community == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            communityService.remove(community.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
