package com.example.springdb.controllers.rest;

import com.example.springdb.controllers.AuthorizationController;
import com.example.springdb.model.place.World;
import com.example.springdb.service.UserService;
import com.example.springdb.service.WorldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@Slf4j
public class RestWorldController {

    private final AuthorizationController authorizationController;
    private final WorldService worldService;
    private final UserService userService;

    @PostMapping("/home/worlds")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(HttpServletRequest request, @RequestBody World world) {
        log.info(world.toString());
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            world.setUser(userService.findByLogin(new String(Base64.getDecoder().decode(authToken)).split(":")[0]));
            worldService.add(world);
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
    }

    @GetMapping("/home/worlds")
    public List<World> find(HttpServletRequest request) {
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            return worldService.findAll(userService.findByLogin(new String(Base64.getDecoder().decode(authToken)).split(":")[0])).stream().toList();
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
        return null;
    }

}
