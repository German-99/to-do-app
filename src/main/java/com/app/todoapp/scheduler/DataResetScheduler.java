package com.app.todoapp.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;

@Component
public class DataResetScheduler {
    @Autowired
    private TaskRepository taskRepository;

    @Scheduled(fixedRate = 20000)
    public void resetData() {
          taskRepository.deleteAll();

        Task task1 = new Task();
        task1.setTitle("Update Spring boot project");
        task1.setCompleted(true);
        taskRepository.save(task1);

        Task task2 = new Task();
        task2.setTitle("do groceries");
        task2.setCompleted(false);
        taskRepository.save(task2);

        Task task3 = new Task();
        task3.setTitle("update CV");
        task3.setCompleted(false);
        taskRepository.save(task3);
    }
}
