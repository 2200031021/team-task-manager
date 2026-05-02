package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskRepository repo;

    // Create Task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return repo.save(task);
    }

    // Get All Tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    // ✅ Updated Task (only status update safely)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {

        Task existing = repo.findById(id).orElseThrow();

        // update only status (safe update)
        if (task.getStatus() != null) {
            existing.setStatus(task.getStatus());
        }

        return repo.save(existing);
    }
}