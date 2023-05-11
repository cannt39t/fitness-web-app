package com.cantt39t.fitnesswebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentDto {

    @NotEmpty
    private String value;

    private Integer authorId;

    private Integer trainingId;
}
