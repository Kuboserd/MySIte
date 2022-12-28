package com.example.springdb.service;

import com.example.springdb.model.User;
import com.example.springdb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRepositoryTestService implements CommandLineRunner {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;


    @Override
    public void run(String... args) throws Exception {

        log.info("Hash generated for user1: {}", encoder.encode("user1"));
        log.info("Hash generated for admin: {}", encoder.encode("admin"));

/*        userRepository.save(new User("Zenek", "Martyniuk", "zmartyniuk", "dobrzespiewam!"));
        userRepository.save(new User("Jan", "Nowak", "nowakj", "proste123"));
        userRepository.save(new User("Olek", "Kolodziej", "xXxOlegxXx", "smiercrzadom"));
        userRepository.save(new User("Anna", "Radek", "DaRadek", "szybkiehaslo1"));
        log.info("List of all Users:");
        printAllUsers();

        log.info("Finding user by id:");
        userRepository.findById(1L).ifPresent(user -> log.info(user.toString()));

        log.info("Deleting user by id:");
        userRepository.deleteById(1L);
        printAllUsers();

        log.info("Updating user by id:");
        userRepository.findById(2L).ifPresent(user -> {
                    user.setFirstName("Janusz");
                    userRepository.save(user);
                }
        );
        printAllUsers();

        log.info("Find all users by firstname:");
        userRepository.findAllByFirstName("Janusz").forEach(user -> log.info(user.toString()));

        log.info("Find all users by firstname and lastname");
        userRepository.findAllByFirstNameAndLastName("Janusz", "Nowak").forEach(user -> log.info(user.toString()));

        userRepository.findAllByFirstNameLike("____").forEach(user -> log.info(user.toString()));

        log.info("Find by password:");
        userRepository.findByPassword("proste123").forEach(user -> log.info(user.toString()));

        log.info("Find by login using native sql:");
        userRepository.findByLoginNative("nowakj").ifPresent(user -> log.info(user.toString()));*/
    }

    private void printAllUsers() {
        userRepository.findAll().forEach(user -> log.info(user.toString()));
    }
}
