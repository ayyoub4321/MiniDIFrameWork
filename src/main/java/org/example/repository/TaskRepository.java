package org.example.repository;
import org.example.annotations.Component;
import org.example.model.Task;
import java.util.ArrayList;
import java.util.List;
@Component
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getTitle());
    }
    public List<Task> getAllTasks() {
        return tasks;
    }
}