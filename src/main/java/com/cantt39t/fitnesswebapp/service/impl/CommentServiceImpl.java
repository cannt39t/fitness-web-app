package com.cantt39t.fitnesswebapp.service.impl;

import com.cantt39t.fitnesswebapp.dto.CreateCommentDto;
import com.cantt39t.fitnesswebapp.model.Comment;
import com.cantt39t.fitnesswebapp.repository.CommentRepository;
import com.cantt39t.fitnesswebapp.repository.ExerciseRepository;
import com.cantt39t.fitnesswebapp.repository.TrainingRepository;
import com.cantt39t.fitnesswebapp.repository.UserRepository;
import com.cantt39t.fitnesswebapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TrainingRepository trainingRepository;

    @Override
    public List<Comment> getCommentsForTraining(Integer trainingId) {
        return commentRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public void addCommentToTraining(CreateCommentDto createCommentDto) {
        commentRepository.save(
                Comment.builder()
                        .value(createCommentDto.getValue())
                        .author(userRepository.getReferenceById(createCommentDto.getAuthorId()))
                        .training(trainingRepository.getReferenceById(createCommentDto.getTrainingId()))
                        .build()
        );
    }

}
