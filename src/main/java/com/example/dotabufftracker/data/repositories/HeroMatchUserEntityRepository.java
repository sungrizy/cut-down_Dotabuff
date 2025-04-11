package com.example.dotabufftracker.data.repositories;

import com.example.dotabufftracker.entities.HeroMatchUserEntity;
import com.example.dotabufftracker.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroMatchUserEntityRepository extends JpaRepository<HeroMatchUserEntity, Long> {
    List<HeroMatchUserEntity> findByUser(UserEntity user);
}