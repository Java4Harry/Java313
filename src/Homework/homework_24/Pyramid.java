package lessons.src.Homework.homework_24;

public class Pyramid extends Figures{
    public Pyramid(int width, int height) {
        super(width, height);
    }

    @Override
    public String info() {
        return "пирамида";
    }

    @Override
    public double volume() {
        return this.getHeight() * Math.pow(this.getWidth(), 2) / 3;
    }
}
