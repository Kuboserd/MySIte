package com.example.springdb.controllers.rest;

import com.example.springdb.model.User;
import com.example.springdb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        User temp = userService.findByLogin(user.getLogin());
        try {
            return temp.getLogin().equals(user.getLogin()) && encoder.matches(user.getPassword(), temp.getPassword());
        } catch (NullPointerException e) {
            return false;
        }
    }
}
