package com.example.dotabufftracker.entities;
import com.example.dotabufftracker.entities.HeroStatsEntity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "hero_match_user") // имя таблицы в БД
public class HeroMatchUserEntity {

    public enum HeroRole {
        CARRY,
        MID,
        OFFLANE,
        SUPPORT,
        HARDSUPPORT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", foreignKey = @ForeignKey(name = "fk_hero_match_user_match"))
    private MatchEntity match;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hero_id", foreignKey = @ForeignKey(name = "fk_hero_match_user_hero"))
    private HeroEntity hero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_hero_match_user_user"))
    private UserEntity user;


    @Embedded
    private HeroStatsEntity heroStats;

    @Enumerated(EnumType.STRING)
    private HeroRole heroRole;
}