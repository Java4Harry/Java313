package lessons.src.Homework;

import java.util.Scanner;

public class Homework_27 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Введите количество элементов числового массива: ");
        n = input.nextInt();
        Integer[] arr1 = new Integer[n];
            for (int i = 0; i < arr1.length; i++) {
                System.out.print("-> ");
                arr1[i] = input.nextInt();
            }
        System.out.print("Введите количество элементов строкового массива: ");
        n = input.nextInt();
        input.nextLine();
        String[] arr2 = new String[n];
            for (int i = 0; i < arr2.length; i++) {
                System.out.print("-> ");
                arr2[i] = input.nextLine();
            }
        printArray(arr1);
        printArray(arr2);
    }

    public static <T> void printArray(T[] arr){
        T[] array = arr;
        System.out.print("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
