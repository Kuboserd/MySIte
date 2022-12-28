package com.example.springdb.web.mvc.mappers;

import com.example.springdb.model.User;
import com.example.springdb.web.mvc.form.CreateUserForm;

public class UserMapper {
    public static User toEntity(CreateUserForm form){
        return new User(form.getFirstName(), form.getLastName(), form.getLogin(), form.getPassword(), form.getRole());
    }
}
