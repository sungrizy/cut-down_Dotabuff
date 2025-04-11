package com.example.dotabufftracker.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "matches")
public class MatchEntity {

    public enum GameType{
        RANKED,
        UNRANKED,
        TOURNAMENT,
        LOBBY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date matchDate;

    private String result;


    @ManyToMany
    @JoinTable(
            name = "match_user",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    private List<UserEntity> players;


    @ManyToMany
    @JoinTable(
            name = "match_hero",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "hero_id")
    )
    private List<HeroEntity> heroes;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<HeroMatchUserEntity> heroMatches;


}
