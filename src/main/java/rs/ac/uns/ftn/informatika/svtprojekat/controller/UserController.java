package rs.ac.uns.ftn.informatika.svtprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.informatika.svtprojekat.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;
}
