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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.User;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.dto.*;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @PutMapping(consumes = "application/json", value = "/changePassword")
    public ResponseEntity changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User u = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        rs.ac.uns.ftn.informatika.svtprojekat.entity.User user = userService.findUserByUsername(u.getUsername());
        Integer userId = user.getId();
        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            user.setPassword(passwordEncoder.encode(changePasswordDTO.getPassword()));
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
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

    @PreAuthorize("hasAnyRole('USER', 'ROLE_ADMIN')")
    @PutMapping(consumes = "application/json")
    public ResponseEntity changeUser(@RequestBody ChangeUserDTO changeUserDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User u = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        rs.ac.uns.ftn.informatika.svtprojekat.entity.User user = userService.findUserByUsername(u.getUsername());
        Integer userId = user.getId();
        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            if(changeUserDTO.getEmail() != null) {
                user.setEmail(changeUserDTO.getEmail());
            }
            if(changeUserDTO.getUsername() != null) {
                user.setUsername(changeUserDTO.getUsername());
            }
            if(changeUserDTO.getAvatar() != null) {
                user.setAvatar(changeUserDTO.getAvatar());
            }
            user.setBanned(changeUserDTO.isBanned());
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }

    }
}