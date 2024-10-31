package org.hibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "project")
    private String project;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "workers_on_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "specialist_id")
    )
    private List<Specialist> specialists;

    public Project() {
    }

    public Project(String project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public List<Specialist> getSpecialists() {
        return specialists;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Проект = " +
                project +
                "; ";
    }

    public void addSpecialistToProject(Specialist specialist) {
        if (specialists == null) {
            specialists = new ArrayList<Specialist>();
        }
        specialists.add(specialist);
    }
}
