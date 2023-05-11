package com.cantt39t.fitnesswebapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class SearchController {

    @GetMapping("/search")
    public String findTraining(Model model) {
        model.addAttribute("query", "");
        return "search";
    }

}
