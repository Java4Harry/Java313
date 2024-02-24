package lessons.src.Homework.homework_24;

public class Sphere extends Figures{
    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public String info() {
        return "шар";
    }

    @Override
    public double volume() {
        return ( (double) 4 / 3) * Math.PI * Math.pow(this.getRadius(), 3);
    }
}
