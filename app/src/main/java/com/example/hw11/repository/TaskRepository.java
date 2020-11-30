package com.example.hw11.repository;

import com.example.hw11.model.State;
import com.example.hw11.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TaskRepository uses singleton approach
public class TaskRepository implements IRepository {

    private static TaskRepository sInstance;
    private List<Task> mTasks;

    public static TaskRepository getInstance() {
        if (sInstance == null)
            sInstance = new TaskRepository();

        return sInstance;
    }

    // Constructor produces nothing!
    private TaskRepository() {
        mTasks = new ArrayList<>();

        Task task = new Task();
        task.setTitle("tamrin");
        task.setDescription("ersal");
        //task.setDate(2020/12/03);
        task.setState(State.Doing);

        mTasks.add(task);
    }

    @Override
    public List<Task> getTasks() {
        return mTasks;
    }

    @Override
    public void addTask(Task task) {
        mTasks.add(task);
    }

    @Override
    public void removeTask(Task task) {
        mTasks.remove(task);
    }

    @Override
    public void updateTask(Task task) {
        Task foundTask = getTask(task.getId());
        foundTask.setTitle(task.getTitle());
        foundTask.setDescription(task.getDescription());
        foundTask.setDate(task.getDate());
        //???
        foundTask.setState(task.getState());
    }

    @Override
    public Task getTask(UUID id) {
        return null;
    }

    @Override
    public int getPosition(UUID taskId) {
        return 0;
    }
}
