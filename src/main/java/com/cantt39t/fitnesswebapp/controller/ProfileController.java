package com.cantt39t.fitnesswebapp.controller;


import com.cantt39t.fitnesswebapp.dto.CreateCommentDto;
import com.cantt39t.fitnesswebapp.model.User;
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

@Controller
@AllArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping("/profile")
    public String showWelcome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User currentUser = userService.getUserByEmail(email);
        model.addAttribute("user", currentUser);
        return "profile";
    }

}
