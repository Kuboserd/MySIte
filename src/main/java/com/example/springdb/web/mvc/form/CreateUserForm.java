package com.example.springdb.web.mvc.form;

import com.example.springdb.model.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserForm {

    private String firstName;
    private String lastName;
    @NotBlank(message = "Field cannot be empty")
    @Email(message = "Enter correct email adress")
    private String login;
    @Size(min = 8, message = "Minimal password length: 8")
    @NotBlank(message = "Field cannot be empty")
    private String password;
    private User.Roles role;

}
