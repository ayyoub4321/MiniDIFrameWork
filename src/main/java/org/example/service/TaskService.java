package org.example.service;
import org.example.annotations.Component;
import org.example.annotations.Inject;
import org.example.model.Task;
import org.example.repository.TaskRepository;
@Component
public class TaskService {
    @Inject
    private TaskRepository taskRepository;
    public void createTask(String title) {
        Task task = new Task(title);
        taskRepository.addTask(task);
    }
    public void showTasks() {
        taskRepository.getAllTasks().forEach(task ->
            System.out.println("Task: " + task.getTitle()));
    }
}