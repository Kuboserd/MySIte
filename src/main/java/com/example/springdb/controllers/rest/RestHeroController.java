package com.example.springdb.controllers.rest;

import com.example.springdb.controllers.AuthorizationController;
import com.example.springdb.model.Hero;
import com.example.springdb.service.HeroService;
import com.example.springdb.service.UserService;
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
public class RestHeroController {

    private final AuthorizationController authorizationController;
    private final HeroService heroService;
    private final UserService userService;

    @PostMapping("/home/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(HttpServletRequest request, @RequestBody Hero hero) {
        log.info(hero.toString());
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            hero.setUser(userService.findByLogin(new String(Base64.getDecoder().decode(authToken)).split(":")[0]));
            heroService.add(hero);
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
    }

    @GetMapping("/home/heroes")
    public List<Hero> find(HttpServletRequest request) {
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            return heroService.findAll(userService.findByLogin(new String(Base64.getDecoder().decode(authToken)).split(":")[0]));
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
        return null;
    }

}
