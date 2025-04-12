package com.example.gtasks.controller.task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gtasks.dto.task.TaskRequestDTO;
import com.example.gtasks.dto.task.TaskResponseDTO;
import com.example.gtasks.service.task.TaskService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public Page<TaskResponseDTO> findAllTasks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Boolean completed,
            @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        return service.findAllTasks(title, completed, pageable);
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id) {
        return service.findTaskById(id);
    }

    @PostMapping("")
    public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO dto) {
        return service.createTask(dto);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequestDTO dto) {
        return service.updateTask(id, dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
