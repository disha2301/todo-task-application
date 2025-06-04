package com.gevernova.todo.repository;

import com.gevernova.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepository extends JpaRepository<Task, Long> {
}