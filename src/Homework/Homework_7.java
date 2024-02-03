package Homework;

import java.util.Scanner;

public class Homework_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите размер треугольника (целое положительно число: ");
        if (input.hasNextInt()) {
            int count = input.nextInt();
            if (count <= 0) {
                System.out.println("Ошибка ввода данных!");
            } else {
                int x = 0;
                while (x < count) {
                    System.out.print("*");
                    int y = 1;
                    while (y <= x) {
                        if (y == x) {
                            System.out.print("*");
                            break;
                        } else if (x == count - 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                        y++;
                    }
                    x++;
                    System.out.println();
                }

                input.close();
            }
        } else {
            System.out.println("Ошибка ввода данных!");
        }
    }
}
