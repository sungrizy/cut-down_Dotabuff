package com.example.dotabufftracker.entities;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class HeroStatsEntity {
    private  double winRate;
    private  double kda;
    private int gpm;
    private int xpm;
}
