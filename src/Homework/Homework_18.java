package Homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework_18 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Какой номер задачи будем решать (1 или 2)? ");
        if (input.hasNextByte()) {
            int number = input.nextByte();
            switch (number) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                default:
                    System.out.println("Вы ввели неверный номер задачи! Попробуйте снова.");
            }
        } else {
            System.out.println("Вы ввели символ, букву или дробное число! Попробуйте снова.");
        }
    }
    public static void task1() {
        input.nextLine();
        System.out.print("Введите номера телефонов: ");
        String phones = input.nextLine();
        // +7 499 456-45-78 +74994564578 7 (499) 456 45 78 7 (499) 456-45-78
        String pattern = "[\\s\\+]?7(\\s*\\(?[0-9]{3}\\)?\\s*){2}(\\-?\\s*[0-9]{2}){2}";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phones);
            while (matcher.find()) {
                System.out.println("В системе найден номер: " + matcher.group());
            }
    }
    public static void task2() {
        System.out.print("Введите количество символов: ");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (((i & 1) == 1 && (j & 1) == 1) || ((i & 1) == 0 && (j & 1) == 0)) {
                    System.out.print("X\t");
                } else {
                    System.out.print("O\t");
                }
            }
            System.out.println();
        }
    }
}
