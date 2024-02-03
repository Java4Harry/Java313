package Homework;


import java.util.Scanner;
public class Homework_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 - треугольник, 2 - прямоугольник, 3 - круг");
        System.out.print("Выберите фигуру: ");
        int number = input.nextByte();
        switch (number) {
            case 1: {
                System.out.printf("Площадь: %.2f",triangle(1,1,1));
                break;
            }
            case 2: {
                System.out.printf("Площадь: %.2f", rectangle(1, 1));
                break;
            }
            case 3: {
                System.out.printf("Площадь: %.2f", circle (1));
                break;
            }
            default: {
                System.out.println("Не правильно введен номер фигуры!");
            }
        }
    }
    public static double triangle(float a, float b, float c) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите сторону a: ");
        a = input.nextFloat();
        System.out.print("Введите сторону b: ");
        b = input.nextFloat();
        System.out.print("Введите сторону c: ");
        c = input.nextFloat();
        float p = (a + b + c) / 2;
        return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
    public static float rectangle(float a, float b) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите основание: ");
        a = input.nextFloat();
        System.out.print("Введите высоту: ");
        b = input.nextFloat();
        return a * b;
    }
    public static double circle(float r) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите радиус круга: ");
        r = input.nextFloat();
        return Math.PI * Math.pow(r, 2);
    }
}
