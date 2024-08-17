package com.example.springdb.service;

import com.example.springdb.model.User;
import com.example.springdb.model.place.World;
import com.example.springdb.repository.WorldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorldService {
    private final WorldRepository worldRepository;

    public List<World> findAll(User user) {
        return worldRepository.findByUserID(user.getId());
    }

    public World add(World world) {
        return worldRepository.save(world);
    }
}
