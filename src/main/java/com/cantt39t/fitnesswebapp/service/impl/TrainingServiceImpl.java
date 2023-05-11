package com.cantt39t.fitnesswebapp.service.impl;

import com.cantt39t.fitnesswebapp.model.Training;
import com.cantt39t.fitnesswebapp.repository.TrainingRepository;
import com.cantt39t.fitnesswebapp.repository.UserRepository;
import com.cantt39t.fitnesswebapp.service.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Training getTrainingById(Integer id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Training> getTrainingsByDifficulty(String difficulty) {
        return trainingRepository.findAllByComplexity(Training.Complexity.valueOf(difficulty));
    }

    @Override
    public List<Training> getTrainingsByName(String searchQuery) {
        return trainingRepository.findAllByNameContainingIgnoreCase(searchQuery);
    }

    @Override
    public List<Training> getTrainingsByDifficultyAndName(String difficulty, String searchQuery) {
        return trainingRepository.findAllByComplexityAndNameContainingIgnoreCase(Training.Complexity.valueOf(difficulty), searchQuery);
    }
}
