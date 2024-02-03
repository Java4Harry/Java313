package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Homework_13 {
    public static void main(String[] args) {
        int [] array = array();
        int max = max(array);
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Максимальное значение: " + max);
    }
    public static int number(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        if (input.hasNextInt()) {
            return input.nextInt();
        } else {
            System.out.println("Ошибка ввода! Введите целое число!");
            return number();
        }
        }
        public static int[] array() {
            int n = number();
            int [] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = (int) (Math.random()*2000 - 1000);
            }
            return array;
        }
    public static int max(int... num){
        int max = Integer.MIN_VALUE;
        for (int i: num) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
