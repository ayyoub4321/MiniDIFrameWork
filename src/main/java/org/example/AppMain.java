package org.example;
import org.example.core.AnnotationContext;
import org.example.repository.TaskRepository;
import org.example.service.TaskService;
import java.util.List;
public class AppMain {
    public static void main(String[] args) throws Exception {
        AnnotationContext context = new AnnotationContext(List.of(
            TaskService.class,
            TaskRepository.class
        ));
        TaskService taskService = context.getBean(TaskService.class);
        taskService.createTask("Étudier DI");
        taskService.createTask("Faire un café");
        taskService.showTasks();
    }
}