package org.springboot.homework79.model;

public class Student {
    private String name;
    private String surname;
    private int age;
    private int course;
    private String group;
    private String speciality;

    public Student(String name, String surname, int age, int course, String group, String speciality) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
        this.group = group;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
