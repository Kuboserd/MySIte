package com.example.springdb.web.mvc;

import com.example.springdb.model.User;
import com.example.springdb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class WelcomeController {

    private final UserService userService;

    @GetMapping
    public String welcomePage(ModelMap map){
        User user = userService.findById(3L);
        map.addAttribute("user", user);
        return "index";
    }
}
