package com.example.springdb.controllers.rest;

import com.example.springdb.model.User;
import com.example.springdb.model.place.World;
import com.example.springdb.service.UserService;
import com.example.springdb.service.WorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class RestWorldController {
    private final WorldService worldService;

    @PostMapping("/home/worlds")
    public World save(World world){
        return worldService.addWorld(world);
    }
    @GetMapping("/home/worlds")
    public List<World> user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        System.out.println(new String(Base64.getDecoder().decode(authToken)).split(":")[0]);
        return null;
    }

}
