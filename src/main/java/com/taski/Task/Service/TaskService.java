package com.taski.Task.Service;

import com.taski.Task.Exception.TaskNotFoundException;
import com.taski.Task.Model.Task;
import com.taski.Task.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);

        if (updatedTask.getTitle() != null) {
            task.setTitle(updatedTask.getTitle());
        } else {
            task.setTitle(task.getTitle());
        }

        if (updatedTask.getDescription() != null) {
            task.setDescription(updatedTask.getDescription());
        } else {
            task.setDescription(task.getDescription());
        }

        if (updatedTask.getStatus() != null) {
            task.setStatus(updatedTask.getStatus());
        } else {
            task.setStatus(task.getStatus());
        }
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        Task task = getTaskById(id);
        if (task != null){
            taskRepository.deleteById(id);
        }
    }
}
