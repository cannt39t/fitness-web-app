package com.cantt39t.fitnesswebapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String login;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Goal goal;

    @Enumerated(EnumType.STRING)
    private Form form;

    private String name;

    private int age;

    private int height;

    private int weight;

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public enum Goal {
        GAIN_MUSCLE,
        LOSE_FAT,
        MAINTAIN_WEIGHT
    }

    public enum Form {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED
    }
}

