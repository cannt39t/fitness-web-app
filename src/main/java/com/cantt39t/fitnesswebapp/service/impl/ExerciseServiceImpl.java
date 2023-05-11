package com.cantt39t.fitnesswebapp.service.impl;

import com.cantt39t.fitnesswebapp.model.Exercise;
import com.cantt39t.fitnesswebapp.repository.ExerciseRepository;
import com.cantt39t.fitnesswebapp.repository.TrainingRepository;
import com.cantt39t.fitnesswebapp.repository.UserRepository;
import com.cantt39t.fitnesswebapp.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getExercisesForTraining(Integer id) {
        return exerciseRepository.findAllByTrainingsId(id);
    }
}
