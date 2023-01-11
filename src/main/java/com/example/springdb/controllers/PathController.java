package com.example.springdb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class PathController {

    @RequestMapping(value = {"/home/**", "/admin/**"})
    public boolean move(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return false;
    }


}
