package com.example.gtasks.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtasks.model.task.Task;
import com.example.gtasks.repository.task.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAllTasks() {
        return repository.findAll();    
    }

    public Optional<Task> findTaskById(Long id) {
        return repository.findById(id);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task data) {
        Optional<Task> optTask = repository.findById(id);
        if (optTask.isPresent()){
            Task task = optTask.get();
            if (data.getTitle() != null) {
                task.setTitle(data.getTitle());
            }
            if (data.getDescription() != null) {
                task.setDescription(data.getDescription());
            }
            if (data.getCompleted() != null) {
                task.setCompleted(data.getCompleted());
            }
            return Optional.of(repository.save(task));
        }
        return Optional.empty();
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
