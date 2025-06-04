package com.gevernova.todo.mapper;

import com.gevernova.todo.dto.TaskRequestDTO;
import com.gevernova.todo.dto.TaskResponseDTO;
import com.gevernova.todo.entity.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto) {
        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .priority(dto.getPriority())
                .status(dto.getStatus() != null ? dto.getStatus() : Task.Status.PENDING)
                .dueDate(dto.getDueDate())
                .build();
    }

    public static TaskResponseDTO toDTO(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .priority(task.getPriority())
                .status(task.getStatus())
                .dueDate(task.getDueDate())
                .build();
    }
}