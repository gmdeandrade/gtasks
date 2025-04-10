package com.example.gtasks.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.gtasks.dto.task.TaskRequestDTO;
import com.example.gtasks.dto.task.TaskResponseDTO;
import com.example.gtasks.execptions.TaskNotFoundException;
import com.example.gtasks.model.task.Task;
import com.example.gtasks.repository.task.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Page<TaskResponseDTO> findAllTasks(String title, Boolean completed, Pageable pageable) {
        Page<Task> tasks;

        if (title != null && !title.isBlank() && completed != null) {
            tasks = repository.findByCompletedAndTitleContainingIgnoreCase(completed, title, pageable);
        } else if (title != null && !title.isBlank()) {
            tasks = repository.findByTitleContainingIgnoreCase(title, pageable);
        } else if (completed != null) {
            tasks = repository.findByCompleted(completed, pageable);
        } else {
            tasks = repository.findAll(pageable);
        }

        return tasks.map(this::toResponseDTO);
    }

    public TaskResponseDTO findTaskById(Long id) {
        return toResponseDTO(repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id)));
    }

    public TaskResponseDTO createTask(TaskRequestDTO dto) {
        return toResponseDTO(repository.save(toEntity(dto)));
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        merge(task, dto);
        return toResponseDTO(repository.save(task));
    }

    public void deleteTask(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        repository.delete(task);
    }

    private Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted());
        return task;
    }

    private TaskResponseDTO toResponseDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.getCompleted());
        return dto;
    }

    private void merge(Task task, TaskRequestDTO dto) {
        if (dto.getTitle() != null)
            task.setTitle(dto.getTitle());
        if (dto.getDescription() != null)
            task.setDescription(dto.getDescription());
        if (dto.getCompleted() != null)
            task.setCompleted(dto.getCompleted());
    }

}
