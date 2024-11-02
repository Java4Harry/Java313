package org.spring.mvc.task.service;

import org.spring.mvc.task.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
