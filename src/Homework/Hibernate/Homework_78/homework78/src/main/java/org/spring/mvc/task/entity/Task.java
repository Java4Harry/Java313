package org.spring.mvc.task.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "list")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task")
    private String task;

    public Task() {
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Задача №" +
                id +
                " - " + task;
    }
}
