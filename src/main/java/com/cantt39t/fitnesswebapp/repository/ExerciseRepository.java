package com.cantt39t.fitnesswebapp.repository;

import com.cantt39t.fitnesswebapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {



}
