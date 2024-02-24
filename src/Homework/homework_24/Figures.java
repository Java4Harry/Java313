package lessons.src.Homework.homework_24;

    public abstract class Figures {
    private int width;
    private int height;
    private double radius;

    public Figures(double radius) {
        this.radius = radius;
    }

    public Figures(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Figures(int height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public abstract String info();

    public abstract double volume();
}
