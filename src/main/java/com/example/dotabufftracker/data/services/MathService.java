package com.example.dotabufftracker.data.services;

import com.example.dotabufftracker.data.repositories.MatchEntityRepository;
import com.example.dotabufftracker.entities.MatchEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class MathService {
    private  final MatchEntityRepository matchEntityRepository;

    public List<MatchEntity> getAllMatches(){
        return matchEntityRepository.findAll();
    }

    public MatchEntity getMatchById(Long id){
        return matchEntityRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Match not found"));
    }
    public MatchEntity saveMatch(MatchEntity match){
        return  matchEntityRepository.save(match);
    }
}
