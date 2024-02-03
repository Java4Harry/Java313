package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Homework_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        if (input.hasNextInt()) {
                int n = input.nextInt();
                if (n > 0) {
                    int[] array = arrayCreate(n);
                    System.out.println(Arrays.toString(array));
                    System.out.print("Количество отрицательных элементов массива = " + negative(0, 0, array));
                } else {
                    System.out.println("Ошибка ввода! Введите целое положительное число!");
                }
        } else {
            System.out.println("Ошибка ввода! Введите целое положительное число!");
        }

    }
    public static int[] arrayCreate(int n) {
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random()*200 - 100);
        }
        return array;
        }
    public static int negative (int i, int count, int[] array){
            if (i == array.length) {
                    return count;
                } else {
                    if (array[i] < 0) {
                        count++;
                }
                    return negative (i+1, count, array);
        }
    }
    }
