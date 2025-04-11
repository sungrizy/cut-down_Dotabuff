package com.example.dotabufftracker.data.repositories;

import com.example.dotabufftracker.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByNickName(String nickname);
    Optional<UserEntity> findBySteamId(String steamId);

}
