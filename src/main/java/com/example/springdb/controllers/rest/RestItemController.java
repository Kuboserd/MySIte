package com.example.springdb.controllers.rest;

import com.example.springdb.controllers.AuthorizationController;
import com.example.springdb.model.shop.item.Item;
import com.example.springdb.service.ItemService;
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
public class RestItemController {

    private final AuthorizationController authorizationController;
    private final ItemService itemService;
    private final UserService userService;

    @PostMapping("/home/items")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(HttpServletRequest request, @RequestBody Item item) {
        log.info(item.toString());
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            //TODO: dodac dodawanie sklepu do krainy/swiata
            itemService.add(item);
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
    }

    @GetMapping("/home/items")
    public List<Item> find(HttpServletRequest request) {
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            return itemService.findAll(userService.findByLogin(new String(Base64.getDecoder().decode(authToken)).split(":")[0])).stream().toList();
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
        return null;
    }

}
