package com.example.gtasks.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gtasks.model.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}