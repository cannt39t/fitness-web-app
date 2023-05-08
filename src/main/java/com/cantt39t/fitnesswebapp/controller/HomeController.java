package com.cantt39t.fitnesswebapp.controller;


import com.cantt39t.fitnesswebapp.dto.CreateUserRequestDto;
import com.cantt39t.fitnesswebapp.model.User;
import com.cantt39t.fitnesswebapp.service.UserService;
import com.cantt39t.fitnesswebapp.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@AllArgsConstructor
public class HomeController {

    private final UserServiceImpl userService;

    @GetMapping("/home")
    public String showWelcome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User currentUser = userService.getUserByEmail(email);
        System.out.println(currentUser);
        model.addAttribute("name", currentUser.getName());
        return "home";
    }
}
