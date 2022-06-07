package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Community;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.CommunityDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.SuspendCommunityDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.service.CommunityService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    //@PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<CommunityDTO>> getCommunities() {
        List<Community> communities = communityService.findAll();

        List<CommunityDTO> communitiesDTO = new ArrayList<>();
        for (Community c : communities) {
            communitiesDTO.add(new CommunityDTO(c));
        }

        return new ResponseEntity<>(communitiesDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CommunityDTO> getCommunity(@PathVariable("id") Integer id) {
        Community community = communityService.findOne(id);
        if (community == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);
    }

    //@PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<CommunityDTO> postCommunity(@RequestBody CommunityDTO communityDTO){
        Community community = new Community();
        LocalDate date = LocalDate.now();

        community.setDescription(communityDTO.getDescription());
        community.setName(communityDTO.getName());
        community.setCreationDate(date.toString());
        community.setSuspended(false);

        if(community.getDescription() == null || community.getName() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        communityService.save(community);
        return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CommunityDTO> putCommunity(@RequestBody CommunityDTO communityDTO, @PathVariable("id") Integer id){
        if (communityDTO.getId() != null) {
            Community community = communityService.findOne(id);

            if(community == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            community.setDescription(communityDTO.getDescription());
            community.setName(communityDTO.getName());
            community.setSuspended(communityDTO.isSuspended());
            community.setSuspendedReason(communityDTO.getSuspendedReason());

            if(community.getDescription() == null || community.getName() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            communityService.save(community);
            return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCommunity(@PathVariable("id") Integer id) {
        if (id != null) {
            Community community = communityService.findOne(id);

            if(community == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            communityService.remove(community.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/{id}/suspend")
    public ResponseEntity<CommunityDTO> suspend(@PathVariable("id") Integer id, @RequestBody SuspendCommunityDTO suspendCommunityDTO){
        Community community = communityService.findOne(id);
        community.setSuspended(true);
        community.setSuspendedReason(suspendCommunityDTO.getSuspendedReason());

        if(community == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        communityService.save(community);
        return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);
    }
}
