package com.entity;

public class Worker {
    private int id;
    private String fullName;
    private String dob;
    private String qualification;
    private String section;
    private String email;
    private String phone;
    private String password;

    public Worker() {}

    public Worker(int id, String fullName, String dob, String qualification, String section, String email, String phone, String password) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.qualification = qualification;
        this.section = section;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Worker(String fullName, String dob, String qualification, String section, String email, String phone, String password) {
        this.fullName = fullName;
        this.dob = dob;
        this.qualification = qualification;
        this.section = section;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDob() {
        return dob;
    }

    public String getQualification() {
        return qualification;
    }

    public String getSection() {
        return section;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
