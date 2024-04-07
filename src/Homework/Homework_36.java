package lessons.src.Homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Homework_36 {
    public static void main(String[] args) {
        ArrayList<Integer> array = Input();
        System.out.println(array + ": " + array.stream().filter(x -> x % 4 == 0).mapToInt(x -> x * 2).sum());
    }
    public static ArrayList<Integer> Input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите целочисленные значения (0 - завершение ввода):");
        ArrayList<Integer> numbers = new ArrayList<>();
        int i = 0;
        do {
            System.out.print("->");
            i = input.nextInt();
            if (i != 0) numbers.add(i);
        } while (i != 0);
        return numbers;
    }
}

