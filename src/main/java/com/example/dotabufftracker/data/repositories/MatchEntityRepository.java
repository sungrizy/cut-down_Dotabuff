package com.example.dotabufftracker.data.repositories;

import com.example.dotabufftracker.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchEntityRepository extends JpaRepository<MatchEntity, Long> {
    List<MatchEntity> findByGameType(MatchEntity.GameType gameType);
}