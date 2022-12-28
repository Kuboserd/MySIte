package com.example.springdb.web.mvc;

import com.example.springdb.model.User;
import com.example.springdb.service.UserService;
import com.example.springdb.web.mvc.form.CreateUserForm;
import com.example.springdb.web.mvc.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/mvc/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String create(ModelMap map) {
        map.addAttribute("user", new CreateUserForm());
        map.addAttribute("roles", User.Roles.values());
        return "create-user";
    }

    @PostMapping
    public String handleCreated(@ModelAttribute("user") @Valid CreateUserForm form, Errors errors, final RedirectAttributes redirectAttributes, ModelMap model) {
        log.info("Creating user from form {}", form);
        if (errors.hasErrors()) {
            model.addAttribute("roles", User.Roles.values());
            return "create-user";
        }
        userService.save(UserMapper.toEntity(form));
        redirectAttributes.addAttribute("message", "Użytkownik o loginie: " + form.getLogin() + " został pomyślnie dodany!");
        return "redirect:/mvc/user/list";
    }

    @GetMapping("/list")
    public String list(ModelMap map, @ModelAttribute("message") String message) {
        map.addAttribute("users", userService.findAll());
        if (!message.isBlank()) {
            map.addAttribute("message", message);
        }
        return "users-list";
    }
}
