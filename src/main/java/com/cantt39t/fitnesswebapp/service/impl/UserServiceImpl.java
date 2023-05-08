package com.cantt39t.fitnesswebapp.service.impl;

import com.cantt39t.fitnesswebapp.dto.CreateUserRequestDto;
import com.cantt39t.fitnesswebapp.dto.CreateUserResponseDto;
import com.cantt39t.fitnesswebapp.dto.UserUpdateInfoDto;
import com.cantt39t.fitnesswebapp.model.User;
import com.cantt39t.fitnesswebapp.repository.UserRepository;
import com.cantt39t.fitnesswebapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public List<CreateUserResponseDto> findAll() {
        return userRepository.findAll().stream().map(u -> CreateUserResponseDto.builder()
                .login(u.getName())
                .id(u.getId())
                .email(u.getEmail())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<CreateUserResponseDto> findById(Integer id) {
        return userRepository.findAllById(List.of(id))
                .stream().map(u -> CreateUserResponseDto.builder()
                        .login(u.getName())
                        .id(u.getId())
                        .email(u.getEmail())
                        .build()
                ).findFirst();
    }

    @Override
    public CreateUserResponseDto create(CreateUserRequestDto userDto) {
        User user = User.builder()
                .login(userDto.getLogin())
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .build();
        userRepository.save(user);
        return CreateUserResponseDto.fromEntity(userRepository.save(user));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).orElse(User.builder().build());
    }

    @Override
    public void updateUser(UserUpdateInfoDto updateInfoDto) {
        User user = userRepository.getReferenceById(updateInfoDto.getId());
        User updatedUser = User.builder()
                .id(updateInfoDto.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .name(updateInfoDto.getName())
                .age(updateInfoDto.getAge())
                .form(updateInfoDto.toUser().getForm())
                .goal(updateInfoDto.toUser().getGoal())
                .gender(updateInfoDto.toUser().getGender())
                .password(user.getPassword())
                .height(updateInfoDto.getHeight())
                .weight(updateInfoDto.getWeight())
                .build();
        userRepository.save(updatedUser);
    }
}
