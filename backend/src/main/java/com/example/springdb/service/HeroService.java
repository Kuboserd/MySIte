package com.example.springdb.service;

import com.example.springdb.model.Hero;
import com.example.springdb.model.User;
import com.example.springdb.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeroService {
    private final HeroRepository heroRepository;

    public List<Hero> findAll(User user) {
        List<Hero> temp = heroRepository.findByUserID(user.getId());
        log.info(temp.toString());
        return temp;
    }

    public Hero add(Hero hero) {
        return heroRepository.save(hero);
    }
}
