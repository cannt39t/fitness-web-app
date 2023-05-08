package com.cantt39t.fitnesswebapp.service;

import com.cantt39t.fitnesswebapp.dto.CreateUserRequestDto;
import com.cantt39t.fitnesswebapp.dto.CreateUserResponseDto;
import com.cantt39t.fitnesswebapp.dto.UserUpdateInfoDto;
import com.cantt39t.fitnesswebapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<CreateUserResponseDto> findAll();

    Optional<CreateUserResponseDto> findById(Integer id);

    CreateUserResponseDto create(CreateUserRequestDto userDto);

    User getUserByEmail(String email);

    void updateUser(UserUpdateInfoDto updateInfoDto);

}
