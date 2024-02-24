package lessons.src.Homework.homework_24;

public class Cylinder extends Figures{
    public Cylinder(int height, double radius) {
        super(height, radius);
    }

    @Override
    public String info() {
        return "цилиндр";
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(this.getRadius(), 2) * this.getHeight();
    }
}
