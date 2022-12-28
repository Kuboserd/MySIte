package com.example.springdb.web.rest;

import com.example.springdb.model.User;
import com.example.springdb.service.UserService;
import com.example.springdb.service.auth.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class RestUserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        String loggedUsername = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        User foundUser = userService.findById(user.getId());
        if(!loggedUsername.equals(foundUser.getLogin())){
            throw new RuntimeException("You can update onyl your onw data");
        }
        return userService.update(user);
    }

    @GetMapping("/search")
    public List<User> findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return userService.findByFirstNameAndLastName(firstName, lastName);
    }

}
