package com.cantt39t.fitnesswebapp.controller;

import com.cantt39t.fitnesswebapp.dto.CreateUserRequestDto;
import com.cantt39t.fitnesswebapp.dto.UserUpdateInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class AuthController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new CreateUserRequestDto());
        return "registration";
    }

}
