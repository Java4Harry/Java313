package Homework;

import java.util.Arrays;

public class Homework_9 {
    public static void main(String[] args) {
        int [] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*10);
            for (int j = 0; j < i; j++) {
                if (array[j] == array[i]) {
                    array[i] = (int) (Math.random()*10);
                    j = -1;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
