package org.example;
import org.example.service.TaskService;
import org.example.xml.XMLContext;
public class AppMainXML {
    public static void main(String[] args) throws Exception {
        XMLContext context = new XMLContext("src/main/resources/beans.xml");
        TaskService service = (TaskService) context.getBean("taskService");
        service.createTask("Tâche depuis XML");
        service.showTasks();
    }
}