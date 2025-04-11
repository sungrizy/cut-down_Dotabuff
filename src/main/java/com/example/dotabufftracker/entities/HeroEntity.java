package com.example.dotabufftracker.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "heroes")
public class HeroEntity {

    public enum Maincharacteristic {
        STRENGTH,
        AGILITY,
        INTELLIGENCE,
        UNIVERSAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String localizedName;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Maincharacteristic maincharacteristic;



    @ManyToMany
    @JoinTable(
            name = "match_hero",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "match_id")
    )
    private List<MatchEntity> matches;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL)
    private List<HeroMatchUserEntity> heroMatches;

}