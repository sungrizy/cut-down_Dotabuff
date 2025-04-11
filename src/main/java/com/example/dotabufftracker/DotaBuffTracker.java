package com.example.dotabufftracker;

import com.example.dotabufftracker.data.repositories.UserEntityRepository;
import com.example.dotabufftracker.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DotaBuffTracker {

	private final UserEntityRepository userEntityRepository;

	public DotaBuffTracker(UserEntityRepository userEntityRepository) {
		this.userEntityRepository = userEntityRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DotaBuffTracker.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void ready(){
		userEntityRepository
				.findByNicknameStartsWithIgnoreCaseOrSteamId("<wrong>",
						"54365432");

	}

}
