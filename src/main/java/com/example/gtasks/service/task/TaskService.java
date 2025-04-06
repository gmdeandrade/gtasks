package com.example.gtasks.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtasks.execptions.TaskNotFoundException;
import com.example.gtasks.model.task.Task;
import com.example.gtasks.repository.task.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAllTasks() {
        return repository.findAll();    
    }

    public Task findTaskById(Long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Long id, Task data) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        if (data.getTitle() != null) {
            task.setTitle(data.getTitle());
        }
        if (data.getDescription() != null) {
            task.setDescription(data.getDescription());
        }
        if (data.getCompleted() != null) {
            task.setCompleted(data.getCompleted());
        }
        return repository.save(task);
    }

    public void deleteTask(Long id){
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        repository.delete(task);
    }
}
