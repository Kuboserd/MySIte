package com.example.springdb.service;

import com.example.springdb.model.User;
import com.example.springdb.model.place.World;
import com.example.springdb.repository.UserRepository;
import com.example.springdb.repository.WorldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorldService {
    private final UserService userService;

    private final WorldRepository worldRepository;

    private final BCryptPasswordEncoder encoder;


    public List<World> findAll(User user) {
        return worldRepository.findByUserID(user.getId()).stream().toList();
    }

    public World addWorld(World world) {
        return worldRepository.save(world);
    }
}
