package Homework;

import java.util.Scanner;

public class Homework_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte coin;
        System.out.print("Введите количество копеек (от 1 до 99): ");
        coin = input.nextByte();
        if (coin < 1 || coin > 99) {
            System.out.println("Ошибка ввода данных");
        }
        else if (((coin % 10) >= 5 && (coin % 10) <= 9) || (coin % 10) == 0) {
            System.out.printf("%d копеек", coin);
        }
        else if ((coin % 10) == 1 && coin != 11) {
            System.out.printf("%d копейка", coin);
        }
        else if ((coin % 10) >=2 && (coin % 10) <= 4 && coin != 12 && coin != 13 && coin != 14) {
            System.out.printf("%d копейки", coin);
        }
        else {
            System.out.printf("%d копеек", coin);
        }
        input.close();
    }
}
