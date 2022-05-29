package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.LoginDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.RegisterDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.UserDTO;
import rs.ac.uns.ftn.informatika.svtprojekat.security.TokenUtils;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.findAll();

        List<UserDTO> usersDTO = new ArrayList<>();
        for (User u : users) {
            System.out.println(u.toString());
            usersDTO.add(new UserDTO(u));
        }

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id) {
        User user = userService.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<RegisterDTO> register(@RequestBody RegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setAvatar(registerDTO.getAvatar());
        user.setEmail(registerDTO.getEmail());
        user.setBanned(false);
        user.setPassword(registerDTO.getPassword());
        LocalDate date = LocalDate.now();
        user.setRegistrationDate(date);

        User usernameUser = userService.findUserByUsername(user.getUsername());

        if(user.getUsername() == null || user.getAvatar() == null ||
            user.getEmail() == null || user.getPassword() == null ||
             user.getRegistrationDate() == null) {
             return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        if(usernameUser == null ) {
            System.out.println(user);
            user = userService.createUser(new RegisterDTO(user));
            return new ResponseEntity<>(new RegisterDTO(user), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    //popravi changePassword
    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping(consumes = "application/json", value = "/{id}")
    public ResponseEntity changePassword(@RequestBody RegisterDTO userDTO, @PathVariable("id") Integer id) {
        User user = userService.findOne(id);
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

    @PostMapping("/login")
    public ResponseEntity<String> loginSecurity(@RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsername());
                System.out.println(tokenUtils.generateToken(userDetails));
            return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}