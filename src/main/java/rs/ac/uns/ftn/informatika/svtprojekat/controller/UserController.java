package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

        User usernameDb = userService.findUserByUsername(user.getUsername());
        User idDB = userService.findOne(user.getId());

        // Dodati validaciju

        if(usernameDb == null && idDB == null) {
            user = userService.save(user);
            System.out.println(user);
            return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
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
}
