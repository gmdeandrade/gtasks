package com.example.gtasks.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.gtasks.model.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByCompletedAndTitleContainingIgnoreCase(Boolean completed, String title, Pageable pageable);

    Page<Task> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<Task> findByCompleted(Boolean completed, Pageable pageable);
}