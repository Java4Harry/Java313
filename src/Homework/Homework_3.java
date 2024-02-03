package Homework;

import java.util.Scanner;

public class Homework_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name, city;
        byte number, age;
        System.out.println("Какое задание Вы хотите проверить?");
        System.out.println("Введите цифру 1 (задание №1) или 2 (задание №2)!");
        number = input.nextByte();
        if (number == 1) {
            System.out.printf("%-15s %-6s %-8s %1d %-13s%-2d %48s %d %-4s%d%n", "переменная типа", Byte.TYPE,
                    "занимает", Byte.BYTES, "Байт памяти (", Byte.SIZE, "бит памяти), и принимает значения в диапазоне " +
                            "от", Byte.MIN_VALUE, "до", Byte.MAX_VALUE);
            System.out.printf("%-15s %-6s %-8s %1d %-13s%-2d %48s %d %-4s%d%n", "переменная типа", Short.TYPE,
                    "занимает", Short.BYTES, "Байт памяти (", Short.SIZE, "бит памяти), и принимает значения в диапазоне " +
                            "от", Short.MIN_VALUE, "до", Short.MAX_VALUE);
            System.out.printf("%-15s %-6s %-8s %1d %-13s%-2d %48s %d %-4s%d%n", "переменная типа", Integer.TYPE,
                    "занимает", Integer.BYTES, "Байт памяти (", Integer.SIZE, "бит памяти), и принимает значения в диапазоне " +
                            "от", Integer.MIN_VALUE, "до", Integer.MAX_VALUE);
            System.out.printf("%-15s %-6s %-8s %1d %-13s%-2d %48s %d %-4s%d%n", "переменная типа", Long.TYPE,
                    "занимает", Long.BYTES, "Байт памяти (", Long.SIZE, "бит памяти), и принимает значения в диапазоне " +
                            "от", Long.MIN_VALUE, "до", Long.MAX_VALUE);
            System.out.println();
            System.out.printf("%-15s %-6s %-8s %1d %-13s%-2d %48s %e %-4s%e%n", "переменная типа", Float.TYPE,
                    "занимает", Float.BYTES, "Байт памяти (", Float.SIZE, "бит памяти), и принимает значения в диапазоне " +
                            "от", Float.MIN_VALUE, "до", Float.MAX_VALUE);
            System.out.printf("%-15s %-6s %-8s %1d %-13s%-2d %s %e %-4s%e%n", "переменная типа", Double.TYPE,
                    "занимает", Double.BYTES, "Байт памяти (", Double.SIZE, "бит памяти), и принимает значения в диапазоне " +
                            "от", Double.MIN_VALUE, "до", Double.MAX_VALUE);
        } else if (number == 2) {
            input.nextLine();
            System.out.println("What is your name?");
            name = input.nextLine();
            System.out.println("How old are you?");
            age = input.nextByte();
            System.out.println("Where are you live?");
            input.nextLine();
            city = input.nextLine();
            System.out.printf("This is %s %nIt is %d %nHe lives in %s %n", name, age, city);
        }
        else {
            System.out.println("Вы ввели неверный номер задания!");
        }
        input.close();
    }
}
