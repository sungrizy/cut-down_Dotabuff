package com.example.dotabufftracker.data.repositories;

import com.example.dotabufftracker.entities.HeroEntity;
import com.example.dotabufftracker.entities.HeroMatchUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroEntityRepository extends JpaRepository<HeroEntity, Integer> {
    List<HeroEntity> findByMaincharacteristic(HeroEntity.Maincharacteristic characteristic);
}