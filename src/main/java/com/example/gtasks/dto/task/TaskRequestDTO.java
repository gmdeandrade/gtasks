package com.example.gtasks.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {
    @NotBlank
    private String title;
    private String description;
    @NotNull
    private Boolean completed;
}