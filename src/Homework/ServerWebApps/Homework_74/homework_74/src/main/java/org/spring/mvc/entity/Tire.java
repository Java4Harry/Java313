package org.spring.mvc.entity;

public class Tire {
    private int radius;
    private String check;
    private int width;
    private int height;

    public int getRadius() {
        return radius;
    }

    public String getCheck() {
        return check;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
