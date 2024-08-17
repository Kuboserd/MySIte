package com.example.springdb.controllers.rest;

import com.example.springdb.controllers.AuthorizationController;
import com.example.springdb.model.shop.Shop;
import com.example.springdb.service.ShopService;
import com.example.springdb.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@Slf4j
public class RestShopController {

    private final AuthorizationController authorizationController;
    private final ShopService shopService;
    private final UserService userService;

    @PostMapping("/home/shops")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(HttpServletRequest request, @RequestBody Shop shop) {
        log.info(shop.toString());
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            //TODO: dodac dodawanie sklepu do krainy/swiata
            shopService.add(shop);
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
    }

    @GetMapping("/home/shops")
    public List<Shop> find(HttpServletRequest request) {
        return shopService.findall();
    }
/*    @GetMapping("/home/shops")
    public List<Shop> find(HttpServletRequest request) {
        String authToken = authorizationController.isAuthorized(request);
        if (authToken != null) {
            return shopService.findAll(userService.findByLogin(new String(Base64.getDecoder().decode(authToken)).split(":")[0])).stream().toList();
        } else {
            //TODO: dodac wypisywanie w konsoli
        }
        return null;
    }*/

}
