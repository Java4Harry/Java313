package Homework;

import java.util.Scanner;
import java.util.Arrays;

public class Homework_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Задайте количество элементов массива: ");
        int num = input.nextInt();
        int [] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите значение " + (i + 1) + "-го элемента массива: ");
                array[i] = input.nextInt();
        }
        input.close();
        System.out.println("Массив данных: " + Arrays.toString(array));
        System.out.print("Результат: ");
        for (int i = 0; i < array.length; i++) {
            if (i != 0 && array[i] > array[i-1]) {
                System.out.print(array[i] + " ");
            } else continue;
        }
    }
}
