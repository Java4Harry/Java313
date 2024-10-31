package org.hibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "specialists")
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "specialization")
    private String specialization;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "workers_on_project",
            joinColumns = @JoinColumn(name = "specialist_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public Specialist() {
    }

    public Specialist(String name, String surname, String specialization) {
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Специалист{" +
                "id=" + id +
                ", Имя ='" + name + '\'' +
                ", Фамилия ='" + surname + '\'' +
                ", Специальность ='" + specialization + '\'' +
                '}';
    }

    public void addProjectForSpecialist(Project project) {
        if (projects == null) {
            projects = new ArrayList<Project>();
        }
        projects.add(project);
    }
}

