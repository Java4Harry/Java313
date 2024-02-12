package lessons.src.Homework.homework_21;

import java.util.Scanner;

public class Formulas {
    private static byte count;

    static {
        count = 0;
    }
    public static double triangleGeron(double a, double b, double c) {
        count++;
        double p = (a + b + c) / 2;
        return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
    public static double triangle (double a, double h) {
        count++;
        return (a * h) / 2;
    }
    public static double rectangle (double a, double b) {
        count++;
        return a * b;
    }
    public static double square (double a) {
        count++;
        return a * a;
    }

    public static void choice (int n) {
        switch (n) {
            case 0:
                System.out.println("Количество подсчетов площади: " + count);
                break;
            case 1:
                System.out.printf("Площадь треугольника по формуле Герона: %.1f%n", triangleGeron(input(), input(), input()));
                break;
            case 2:
                System.out.printf("Площадь треугольника через основание и высоту: %.1f%n", triangle(input(), input()));
                break;
            case 3:
                System.out.printf("Площадь прямоугольника: %.1f%n", rectangle(input(), input()));
                break;
            case 4:
                System.out.printf("Площадь квадрата: %.1f%n", square(input()));
                break;
            default:
                System.out.println("Ошибка ввода данных!");
                break;
        }
    }
    public static double input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите сторону: ");
        double side = input.nextDouble();
        return side;
    }
}
