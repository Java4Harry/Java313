package org.spring;

public class Father {
    private Baby baby;
    private String name;
    private String surname;
    private String age;

    public Father() {
        System.out.println("Father constructor без параметров");
    }

    public Father(Baby baby) {
        System.out.println("Father constructor с параметром Baby");
        this.baby = baby;
    }

    public void callBaby() {
        System.out.println("Привет, ребенок!");
        baby.say();
    }
}
