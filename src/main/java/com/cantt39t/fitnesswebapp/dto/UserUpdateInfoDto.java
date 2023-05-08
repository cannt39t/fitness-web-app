package com.cantt39t.fitnesswebapp.dto;

import com.cantt39t.fitnesswebapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateInfoDto {

    private Integer id;

    private String gender;

    private String goal;

    private String form;

    private String name;

    private Integer age;

    private Integer height;

    private Integer weight;

    public User toUser() {
        return User.builder()
                .id(id)
                .gender(User.Gender.valueOf(gender.toUpperCase()))
                .goal(User.Goal.valueOf(goal.toUpperCase().replaceAll(" ", "_")))
                .form(User.Form.valueOf(form.toUpperCase()))
                .name(name)
                .age(age)
                .height(height)
                .weight(weight)
                .build();
    }
}
