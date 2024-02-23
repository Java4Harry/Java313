package lessons.src.Homework;

import java.util.Scanner;

public class Homework_23 {
    public static void main(String[] args) {
    Figure figure = new Figure();
    Figure rectangle = new Rectangle();
    Figure triangle = new Triangle();
    rectangle.setWidth(figure.InputWidth());
    rectangle.setHeight(figure.InputHeight());
    triangle.setWidth(figure.getWidth());
    triangle.setHeight(figure.getHeight());
        System.out.printf("Площадь фигуры не определена: %.1f%n", figure.Area());
        System.out.printf("Площадь прямоугольника: %.1f%n", rectangle.Area());
        System.out.printf("Площадь треугольника: %.1f%n", triangle.Area());
    }
}
//  *********** Класс Figure ************
class Figure {
    private double width;
    private double height;

    public Figure() {
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) { this.width = width; }

    public void setHeight(double height) { this.height = height; }

    public double InputWidth() {
        Scanner input = new Scanner(System.in);
            System.out.print("Введите ширину: ");
        this.width = input.nextInt();
        return this.width;
    }

    public double InputHeight() {
        Scanner input = new Scanner(System.in);
            System.out.print("Введите высоту: ");
        this.height = input.nextInt();
        return this.height;
    }

    public double Area() {
        return 0;
    }
}
// *************** Класс Triangle *******************
class Triangle extends Figure {

    public Triangle() {
    }

    @Override
    public double Area() {
        return super.getWidth() * super.getHeight() / 2;
    }
}

// ***************** Класс Rectangle *****************
class Rectangle extends Figure {

    public Rectangle() {
    }

    @Override
    public double Area() {
        return super.getWidth() * super.getHeight();
    }
}
