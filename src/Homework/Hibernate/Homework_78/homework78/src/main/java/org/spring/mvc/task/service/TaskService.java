package org.spring.mvc.task.service;

import jakarta.transaction.Transactional;
import org.spring.mvc.task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public Task getTaskById(long taskId) {
        Task tskDB = taskRepository.findById(taskId).get();
        return tskDB;
    }

    public Task update(Task task, long taskId) {
        Task tskDB = taskRepository.findById(taskId).get();
        tskDB.setTask(task.getTask());
        return taskRepository.save(tskDB);
    }

    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);
    }
}
