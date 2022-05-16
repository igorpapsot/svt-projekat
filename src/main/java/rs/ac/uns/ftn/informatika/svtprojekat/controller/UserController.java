package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.UserDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setAvatar(userDTO.getAvatar());
        user.setEmail(userDTO.getEmail());
        user.setBanned(false);
        user.setPassword(userDTO.getPassword());
        user.setId(userDTO.getId());
        user.setRegistrationDate(userDTO.getRegistrationDate());

        User usernameUser = userService.findUserByUsername(user.getUsername());
        User idUser = userService.findOne(user.getId());

        // Dodati validaciju
        if(user.getUsername() == null || user.getAvatar() == null ||
            user.getEmail() == null || user.getPassword() == null ||
            user.getId() == null || user.getRegistrationDate() == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        if(usernameUser == null && idUser == null) {
            System.out.println(user);
            user = userService.save(user);
            return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        User userDb = userService.findUserByUsername(user.getUsername());

        if(userDb != null && user.getPassword().equals(userDb.getPassword())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity changePassword(@RequestBody UserDTO userDTO) {
        User user = userService.findOne(userDTO.getId());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!user.getPassword().equals(userDTO.getNewPassword()) && user.getPassword().equals(userDTO.getPassword())) {
            user.setPassword(userDTO.getNewPassword());
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}