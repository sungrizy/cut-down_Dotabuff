package com.example.dotabufftracker.data.services;

import com.example.dotabufftracker.data.repositories.HeroEntityRepository;
import com.example.dotabufftracker.entities.HeroEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class HeroService {
    private final HeroEntityRepository heroEntityRepository;

    public List<HeroEntity> getAllHeroes(){
        return heroEntityRepository.findAll();
    }
    public HeroEntity getHeroById(int id){
        return heroEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hero not found"));
    }

    public HeroEntity saveHero (HeroEntity hero){
        return  heroEntityRepository.save(hero);
    }

}
