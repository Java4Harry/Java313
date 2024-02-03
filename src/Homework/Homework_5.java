package Homework;

import java.util.Scanner;

public class Homework_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите время: ");
        byte hours = input.nextByte();
        String res = switch (hours) {
            case 0, 1, 2, 3, 4, 5 -> "Доброй ночи!";
            case 6, 7, 8, 9, 10, 11, 12 -> "Доброе утро!";
            case 13, 14, 15, 16 -> "Добрый день!";
            case 17, 18, 19, 20, 21, 22, 23 -> "Добрый вечер!";
            default -> "Введено некорректное время!";
        };
        System.out.println(res);
        input.close();
    }
}
