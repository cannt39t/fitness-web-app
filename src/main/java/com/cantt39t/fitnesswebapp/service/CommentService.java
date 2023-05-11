package com.cantt39t.fitnesswebapp.service;

import com.cantt39t.fitnesswebapp.dto.CreateCommentDto;
import com.cantt39t.fitnesswebapp.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsForTraining(Integer trainingId);

    void addCommentToTraining(CreateCommentDto createCommentDto);

}
