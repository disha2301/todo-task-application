package com.gevernova.todo.controller;
import com.gevernova.todo.dto.TaskRequestDTO;
import com.gevernova.todo.dto.TaskResponseDTO;
import com.gevernova.todo.entity.Task;
import com.gevernova.todo.mapper.TaskMapper;
import com.gevernova.todo.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.gevernova.todo.mapper.TaskMapper.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO requestDTO) {
        Task task = toEntity(requestDTO);
        Task saved = taskService.createTask(task);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getAllTasks()
                .stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(toDTO(task));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO requestDTO) {
        Task updatedTask = toEntity(requestDTO);
        Task saved = taskService.updateTask(id, updatedTask);
        return ResponseEntity.ok(toDTO(saved));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted with ID: " + id);
    }
}