package lessons.src.Homework.homework_21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("==================================================");
        System.out.println("Площадь треугольника по формуле Герона - 1");
        System.out.println("Площадь треугольника через высоту и основание - 2");
        System.out.println("Площадь прямоугольника - 3");
        System.out.println("Площадь квадрата - 4");
        System.out.println("Завершение всех расчетов - 0");
        System.out.println("==================================================");
        do {
            System.out.print("Выберите номер для подсчета: ");
            number = input.nextByte();
            Formulas.choice(number);
        }
        while (number != 0);
    }
}
