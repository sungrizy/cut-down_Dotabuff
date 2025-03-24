package com.example.playtracker.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @Temporal(TemporalType.TIMESTAMP)
    private Data matchDate;

    private String result;

    @JoinTable(
            name = "match_hero",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "hero_id")
    )

    private List<HeroEntity> heroes;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;



}
