package com.example.playtracker.controllers;

import com.example.playtracker.entities.HeroEntity;
import com.example.playtracker.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HeroController {
    @Autowired
    private HeroService heroService;

    @GetMapping("/heroes")
    public  List<HeroEntity> getHeroes(){
        return heroService.fetchHeroes();
    }

}
