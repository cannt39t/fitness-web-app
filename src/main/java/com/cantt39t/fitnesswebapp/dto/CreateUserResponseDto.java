package com.cantt39t.fitnesswebapp.dto;

import com.cantt39t.fitnesswebapp.model.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CreateUserResponseDto {

    private Integer id;

    private String login;

    private String email;

    public static CreateUserResponseDto fromEntity(User user) {
        return CreateUserResponseDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }

}
