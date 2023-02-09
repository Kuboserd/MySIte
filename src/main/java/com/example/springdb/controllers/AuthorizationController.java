package com.example.springdb.controllers;

import com.example.springdb.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthorizationController {

    private final UserService userService;
    public String isAuthorized(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Bearer ".length()).trim();
        boolean authorized = userService.findByLogin(new String(Base64.getDecoder().decode(authToken)).split(":")[0]) != null;
        log.info(authorized ? "User authorized with token " + authToken : "User was not authorized with token " + authToken);
        return authorized ? authToken : null;
    }

}
