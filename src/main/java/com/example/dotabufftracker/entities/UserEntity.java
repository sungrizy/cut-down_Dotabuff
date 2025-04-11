package com.example.dotabufftracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.EnumType.*;

@EqualsAndHashCode // замінити на метод в готовому проекті
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class UserEntity {

    public enum PlayerRank{
        NORANG,
        HERALD,
        GUARDIAN,
        CRUSADER,
        ARCHON,
        LEGEND,
        ANCIENT,
        DIVINE,
        IMMORTAL
    }

    public enum Status{
        ACTIVE,
        BLOCK,
        CREATED,
        DELETED
    }

    public enum Role{
        USER,
        ADMIN,
        GUEST
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String steamId;

    @Column(nullable = false, unique = true,length = 50)
    private String nickname;

    @Column(nullable = false,unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(STRING)
    private Status status;

    @Enumerated(STRING)
    private Role role;

    @Enumerated(STRING)
    private PlayerRank playerRank;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = new Date();
        if(status == null) status = Status.ACTIVE;
        if(role == null) role = Role.USER;
        if(playerRank == null) playerRank = PlayerRank.NORANG;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }


    @ManyToMany
    @JoinTable(
            name = "match_hero",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "match_id")
    )
    private List<MatchEntity> matches;



}

