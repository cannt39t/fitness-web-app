package com.cantt39t.fitnesswebapp.controller;


import com.cantt39t.fitnesswebapp.dto.CreateCommentDto;
import com.cantt39t.fitnesswebapp.dto.CreateUserRequestDto;
import com.cantt39t.fitnesswebapp.dto.CreateUserResponseDto;
import com.cantt39t.fitnesswebapp.model.Training;
import com.cantt39t.fitnesswebapp.model.User;
import com.cantt39t.fitnesswebapp.repository.ExerciseRepository;
import com.cantt39t.fitnesswebapp.service.CommentService;
import com.cantt39t.fitnesswebapp.service.ExerciseService;
import com.cantt39t.fitnesswebapp.service.TrainingService;
import com.cantt39t.fitnesswebapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class TrainingsController {

    private final TrainingService trainingService;
    private final ExerciseService exerciseService;
    private final CommentService commentService;
    private final UserService userService;

    @GetMapping("/trainings")
    public String allTrainings(@RequestParam(required=false) String difficulty,
                               @RequestParam(required=false) String searchQuery,
                               Model model) {
        List<Training> trainings;

        if (difficulty == "") {
            trainings = trainingService.getAllTrainings();
            model.addAttribute("trainings", trainings);
            return "trainings";
        }

        if (difficulty != null && searchQuery != null) {
            trainings = trainingService.getTrainingsByDifficultyAndName(difficulty, searchQuery);
        } else if (difficulty != null) {
            trainings = trainingService.getTrainingsByDifficulty(difficulty);
        } else if (searchQuery != null) {
            trainings = trainingService.getTrainingsByName(searchQuery);
        } else {
            trainings = trainingService.getAllTrainings();
        }

        model.addAttribute("trainings", trainings);
        return "trainings";
    }


    @GetMapping("/training")
    public String createUser(@RequestParam("trainingId") Integer trainingId, Model model) {
        model.addAttribute("training", trainingService.getTrainingById(trainingId));
        model.addAttribute("exercices", exerciseService.getExercisesForTraining(trainingId));
        model.addAttribute("comments", commentService.getCommentsForTraining(trainingId));
        model.addAttribute("comment", new CreateCommentDto());
        return "training";
    }


}
