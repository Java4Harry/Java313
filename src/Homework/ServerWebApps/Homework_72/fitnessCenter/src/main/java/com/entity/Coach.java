package com.entity;

public class Coach {
    private int id;
    private String coachName;

    public Coach() {}

    public Coach(int id, String coachName) {
        this.id = id;
        this.coachName = coachName;
    }

    public int getId() {
        return id;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
