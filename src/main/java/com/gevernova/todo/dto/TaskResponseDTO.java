package com.gevernova.todo.dto;

import com.gevernova.todo.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Task.Priority priority;
    private Task.Status status;
    private LocalDate dueDate;
}
