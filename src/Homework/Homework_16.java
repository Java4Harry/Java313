package Homework;

import java.util.Scanner;

public class Homework_16 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Каким методом будем решать задачу (1 - String, 2 - StringBuilder)? ");
        if (input.hasNextByte()) {
            int number = input.nextByte();
            switch (number) {
                case 1:
                    methodString(inputStr());
                    break;
                case 2:
                    StringBuilder str = new StringBuilder(inputStr());
                    methodStringBuilder(str);
                    break;
                default:
                    System.out.println("Вы ввели неверный вариант! Попробуйте снова.");
            }
        } else {
            System.out.println("Вы ввели символ, букву или дробное число! Попробуйте снова.");
        }
    }

    public static String inputStr() {
        // После каждого символа 'а' нам надо поставить символ '!'. Такова задача!
        input.nextLine();
        System.out.print("Введите строку: ");
        String str = input.nextLine();
        return str;
    }

    public static void methodString(String str) {
        String strNew = new String();
        System.out.println("Исходная строка: " + str);
        for (int i = 0; i < str.length(); i++) {
            strNew = strNew + str.charAt(i);
            if (str.charAt(i) == 'а') {
                strNew = strNew + '!';
            }
        }
        System.out.print("Новая строка: " + strNew);
    }
    public static void  methodStringBuilder(StringBuilder str) {
        int i=0;
        while (i < str.length()) {
            if (str.charAt(i) == 'а') {
                str.insert(i + 1, '!');
            }
            i++;
        }
        System.out.print("Новая строка: " + str);
    }
}
