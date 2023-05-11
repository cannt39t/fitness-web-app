package com.cantt39t.fitnesswebapp.controller;


import com.cantt39t.fitnesswebapp.dto.CreateCommentDto;
import com.cantt39t.fitnesswebapp.model.Contact;
import com.cantt39t.fitnesswebapp.model.User;
import com.cantt39t.fitnesswebapp.service.ContactService;
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
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String leaveMessage(@ModelAttribute("contact") Contact contact) {
        contactService.addContact(contact);
        return "redirect:/home";
    }

}
