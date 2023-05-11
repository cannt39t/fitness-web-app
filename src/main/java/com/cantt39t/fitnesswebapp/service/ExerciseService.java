package com.cantt39t.fitnesswebapp.service;

import com.cantt39t.fitnesswebapp.model.Exercise;

import java.util.List;

public interface ExerciseService {

    List<Exercise> getExercisesForTraining(Integer id);

}
