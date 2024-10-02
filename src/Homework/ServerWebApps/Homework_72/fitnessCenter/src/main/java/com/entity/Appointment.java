package com.entity;

public class Appointment {
    private int id;
    private int clientId;
    private String fullName;
    private String gender;
    private String age;
    private String appointDate;
    private String email;
    private String phone;
    private String likes;
    private int workerId;
    private String address;
    private String status;

    public Appointment() {}

    public Appointment(int clientId, String fullName, String gender, String age, String appointDate, String email, String phone, String likes, int workerId, String address, String status) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.appointDate = appointDate;
        this.email = email;
        this.phone = phone;
        this.likes = likes;
        this.workerId = workerId;
        this.address = address;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLikes() {
        return likes;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
