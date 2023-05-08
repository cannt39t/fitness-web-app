package com.cantt39t.fitnesswebapp.controller;

import com.cantt39t.fitnesswebapp.dto.CreateUserRequestDto;
import com.cantt39t.fitnesswebapp.dto.CreateUserResponseDto;
import com.cantt39t.fitnesswebapp.dto.UserUpdateInfoDto;
import com.cantt39t.fitnesswebapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String createUser(@ModelAttribute CreateUserRequestDto user, RedirectAttributes ra) {
        CreateUserResponseDto createUserResponseDto = userService.create(user);
        Integer id = createUserResponseDto.getId();
        System.out.println(id);
        ra.addFlashAttribute("id", id);
        return "redirect:/personal_info";
    }

    @GetMapping("/personal_info")
    public String personalInfo(@ModelAttribute("id") Integer id, Model model) {
        System.out.println("Here your id: " + id);
        UserUpdateInfoDto userUpdateInfoDto = new UserUpdateInfoDto();
        System.out.println(userUpdateInfoDto);
        model.addAttribute("updateUserInfo", userUpdateInfoDto);
        return "personal_information";
    }

    @PostMapping("/update_user")
    public String updateUserInfo(@ModelAttribute UserUpdateInfoDto userUpdateInfoDto, @ModelAttribute("id") Integer id) {
        userUpdateInfoDto.setId(id);
        System.out.println(userUpdateInfoDto);
        userService.updateUser(userUpdateInfoDto);
        return "redirect:/login";
    }

}
