package com.example.springdb.service;

import com.example.springdb.model.User;
import com.example.springdb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).toList();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User currentUser = findById(user.getId());
        if (user.getFirstName() == null) {
            user.setFirstName(currentUser.getFirstName());
        }
        if (user.getLastName() == null) {
            user.setLastName(currentUser.getLastName());
        }
        if (user.getLogin() == null) {
            user.setLogin(currentUser.getLogin());
        }
        if (user.getPassword() == null) {
            user.setPassword(currentUser.getPassword());
        }else {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        return userRepository.save(user);
    }

    public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }
}
