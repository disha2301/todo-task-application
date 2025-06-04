package com.gevernova.todo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dueDate;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED
    }
}
