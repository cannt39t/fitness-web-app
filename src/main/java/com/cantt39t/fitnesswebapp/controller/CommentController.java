package com.cantt39t.fitnesswebapp.controller;


import com.cantt39t.fitnesswebapp.dto.CreateCommentDto;
import com.cantt39t.fitnesswebapp.model.User;
import com.cantt39t.fitnesswebapp.service.CommentService;
import com.cantt39t.fitnesswebapp.service.UserService;
import com.cantt39t.fitnesswebapp.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    @PostMapping("/comments")
    public String showWelcome(@RequestParam("trainingId") Integer trainingId, @ModelAttribute("comment")CreateCommentDto createCommentDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User currentUser = userService.getUserByEmail(email);
        Integer userId = currentUser.getId();

        createCommentDto.setAuthorId(userId);
        createCommentDto.setTrainingId(trainingId);

        commentService.addCommentToTraining(createCommentDto);

        return "redirect:/training?trainingId=" + trainingId;
    }

}
