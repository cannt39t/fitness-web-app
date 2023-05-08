package com.cantt39t.fitnesswebapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "exercises")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @Min(0)
    private Integer timeInSeconds;

    @Min(0)
    private Integer count;

    @ManyToMany(mappedBy = "exercises")
    private List<Training> trainings;
}

