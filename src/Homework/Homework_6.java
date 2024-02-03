package Homework;

import java.util.Scanner;

public class Homework_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0, sum = 0, number, min = 0, max = 0;
        double average;
        do {
            System.out.print("Введите целое положительное число: ");
            number = input.nextInt();
            if (number < 0) {
                System.out.println("Ошибка - отрицательное число! Введите число заново!");
                continue;
            };
            i++;
            sum += number;
             max = (number > max && number != 0) ? number : max;
             min = ((number < min && number != 0) || min == 0) ? number : min;
        } while (number != 0);
        if (i != 1) {
            System.out.printf("Среднее арифметическое = %.2f %n", (double) sum / (i - 1));
            System.out.println("Минимальное число = " + min);
            System.out.println("Максимальное число = " + max);
        } else {
            System.out.println("Вы не ввели ни одного числа.");
        }
        input.close();
    }
}
