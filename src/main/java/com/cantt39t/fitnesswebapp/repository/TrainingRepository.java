package com.cantt39t.fitnesswebapp.repository;

import com.cantt39t.fitnesswebapp.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

    List<Training> findAllByComplexityAndNameContainingIgnoreCase(Training.@NotNull Complexity complexity, @NotNull String name);

    List<Training> findAllByNameContainingIgnoreCase(@NotNull String name);

    List<Training> findAllByComplexity(Training.@NotNull Complexity complexity);
}
