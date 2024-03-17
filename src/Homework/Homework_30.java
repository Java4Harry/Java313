package lessons.src.Homework;

import java.util.ArrayList;

public class Homework_30 {
    public static void main(String[] args) {
        ArrayList<Integer> array = ArrayCreation(10);
        System.out.println(array);
        System.out.println("Максимальный элемент: " + ArrayMax(array));
        System.out.println("Минимальный элемент: " + ArrayMin(array));
        System.out.printf("Среднее арифметическое: %.1f", ArrayAverage(array));
    }

    public static ArrayList<Integer> ArrayCreation(int n) {
        ArrayList<Integer> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            array.add(i,(int) Math.floor(Math.random() * 101));
        }
        return array;
    }
    
    public static int ArrayMin (ArrayList<Integer> array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) min = array.get(i);
        }
        return min;
    }

    public static int ArrayMax (ArrayList<Integer> array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) max = array.get(i);
        }
        return max;
    }

    public static double ArrayAverage (ArrayList<Integer> array) {
        double average = 0;
        for (int i = 0; i < array.size(); i++) {
            average += array.get(i);
        }
        return average / array.size();
    }
}
