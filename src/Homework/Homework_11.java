package Homework;

import java.util.Scanner;
public class Homework_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 - треугольник");
        System.out.println("2 - прямоугольник");
        System.out.println("3 - круг");
        System.out.print("Выберите фигуру: ");
        int number = input.nextByte();
        switch (number) {
            case 1: {
                System.out.print("Введите сторону a: ");
                float a = input.nextFloat();
                System.out.print("Введите сторону b: ");
                float b = input.nextFloat();
                System.out.print("Введите сторону c: ");
                float c = input.nextFloat();
                float p = (a + b + c) / 2;
                System.out.printf("Площадь равна: %.2f", (Math.sqrt(p * (p - a) * (p - b) * (p - c))));
                break;
            }
            case 2: {
                System.out.print("Введите сторону a: ");
                float a = input.nextFloat();
                System.out.print("Введите сторону b: ");
                float b = input.nextFloat();
                System.out.printf("Площадь равна: %.2f", (a * b));
                break;
            }
            case 3: {
                System.out.print("Введите радиус круга: ");
                float a = input.nextFloat();
                System.out.printf("Площадь равна: %.2f", (Math.PI) * Math.pow(a, 2));
                break;
            }
            default: {
                System.out.println("Не правильно введен номер фигуры!");
            }
        }
    }
}