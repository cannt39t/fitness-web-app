package com.cantt39t.fitnesswebapp.service;

import com.cantt39t.fitnesswebapp.model.Training;

import java.util.List;

public interface TrainingService {

    List<Training> getAllTrainings();

    Training getTrainingById(Integer id);

    List<Training> getTrainingsByDifficultyAndName(String difficulty, String searchQuery);

    List<Training> getTrainingsByName(String searchQuery);

    List<Training> getTrainingsByDifficulty(String difficulty);

}
