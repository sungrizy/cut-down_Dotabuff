package com.example.dotabufftracker.data.services;


import com.example.dotabufftracker.data.repositories.UserEntityRepository;
import com.example.dotabufftracker.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserEntityRepository userEntityRepository;

    public List<UserEntity> getAllUsers(){
        return userEntityRepository.findAll();
    }
    public UserEntity getUserById(Long id) {
        return userEntityRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")); // Получает пользователя по ID или выбрасывает исключение
    }

    public UserEntity saveUser(UserEntity user) {
        return userEntityRepository.save(user); // Сохраняет нового пользователя или обновляет существующего
    }

}
