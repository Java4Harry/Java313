package lessons.src.Homework.homework_24;

public class Main {
    public static void main(String[] args) {
        final int N = 3;
        Figures[] figure = new Figures[N];
        figure[0] = new Sphere(5);
        figure[1] = new Cylinder(4, 5);
        figure[2] = new Pyramid (5, 4);
        for (Figures element: figure) {
            System.out.printf("Фигура: %-9s | Объем фигуры: %.2f%n", element.info(), element.volume());
        }
        }
    }
