package com.example.hw11.repository;

import com.example.hw11.model.Task;

import java.util.List;
import java.util.UUID;

public interface IRepository {
    List<Task> getTasks();
    void addTask(Task task);
    void removeTask(Task task);
    void updateTask(Task task);
    Task getTask(UUID id);
    int getPosition(UUID taskId);
}
