package com.example.playtracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class UserEntity {

    public enum Status{
        ACTIVE,
        BLOCK
    }

    public enum Role{
        USER,
        ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String steamId;

    @Column(nullable = false, unique = true,length = 50)
    private String nickname;

    @Column(nullable = false,unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = new Date();
        if(status == null) status = Status.ACTIVE;
        if(role == null) role = Role.USER;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }


    @OneToMany(mappedBy = "user")
    private List<MatchEntity> matches;

  /*  @OneToOne(mappedBy = "user")
    private StatisticsEntity statistics;
*/

}



